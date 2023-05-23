package com.easyCarpool.project.payment;

import com.easyCarpool.project.trip1.Trip1;
import com.easyCarpool.project.trip.TripRepository;
import com.easyCarpool.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * this class is the service class of payment
 */
@Service
public class PaymentService {



    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    /***
     * this method creates payment
     * @param payment
     * @return payment
     */
    public Payment createPayment(Payment payment) {

        // Save payment to database
        paymentRepository.save(payment);
        return payment;
    }

    /***
     * this method gets list of payment
     * @return paymentEntities
     */
    public List<Payment> getAllPayments() {
        // Find all paymentEntities
        List<Payment> paymentEntities = paymentRepository.findAll();

        return paymentEntities;
    }

    /***
     * this method deletes payment
     * @param id
     */
    public void deletePayment(Long id) {
        // Delete paymentEntity by ID
       paymentRepository.deleteById(id);
    }
}
