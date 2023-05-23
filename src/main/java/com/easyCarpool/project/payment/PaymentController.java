package com.easyCarpool.project.payment;

import com.easyCarpool.project.trip.TripService;
import com.easyCarpool.project.trip1.Trip1;
import com.easyCarpool.project.trip1.Trip1Create;
import com.easyCarpool.project.trip1.Trip1Service;
import com.easyCarpool.project.user.User;
import com.easyCarpool.project.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * this class is the controller class of payment
 */
@RestController
@RequestMapping(path="api/v1/payment")
public class PaymentController {
    private PaymentService paymentService;
    @Autowired
    private TripService tripService;
    @Autowired
    private UserService userService;

    /***
     * constructor
     * @param paymentService
     */
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService=paymentService;
    }

    /***
     * this method create payment
     * @param paymentCreate
     * @return savedPayment
     */
    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE
    },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody PaymentCreate paymentCreate) {
        Payment savedPayment = new Payment();
        savedPayment.setAmount(paymentCreate.getAmount());
        savedPayment.setFromId(paymentCreate.getFromId());
        savedPayment.setToId(paymentCreate.getToId());
        savedPayment.setTripId(paymentCreate.getTripId());

        paymentService.createPayment(savedPayment);
        tripService.addPaymentToTrip(savedPayment.getTripId(),savedPayment.getId());
        userService.updateUserBalance(paymentCreate.getAmount(),paymentCreate.getFromId(),paymentCreate.getToId());
        return new ResponseEntity<Payment>(savedPayment, HttpStatus.OK);
    }

    /***
     * this method get list of payments
     * @return httpStatus
     */
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    /***
     * this method delete payment
     * @param id
     * @return void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    //payment - trip api


}
