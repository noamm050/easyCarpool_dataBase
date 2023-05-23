package com.easyCarpool.project.trip1;

import com.easyCarpool.project.payment.Payment;
import com.easyCarpool.project.payment.PaymentRepository;
import com.easyCarpool.project.user.User;
import com.easyCarpool.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@Service

 */
public class Trip1Service {

/*
    @Autowired
    private Trip1Repository trip1Repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    public Trip1 createTrip(Trip1 trip1) {

        // Save User to database
        trip1Repository.save(trip1);
        return trip1;
    }
    public List<Trip1> getAllTrips() {
        // Find all UserEntities
        List<Trip1> tripEntities = trip1Repository.findAll();

        return tripEntities;
    }

    public void deleteTrip(Long id) {
        // Delete UserEntity by ID
        trip1Repository.deleteById(id);
    }

    //user-trip api

    public Trip1 addUserToTrip(Long tripId, Long userId) {
        Trip1 trip1 = trip1Repository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        trip1.addUser(user);
        trip1.setPassengerCounter(trip1.getPassengerCounter()+1);
        return trip1Repository.save(trip1);
    }

    public Trip1  removeUserFromTrip(Long tripId, Long userId) {
        Trip1 trip1 = trip1Repository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        trip1.removeUser(user);
        return trip1Repository.save(trip1);
    }

    public Trip1  addDriverToTrip(Long tripId, Long userId) {
        Trip1 trip1 = trip1Repository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        trip1.setDriverId(user.getId());
        return trip1Repository.save(trip1);
    }


    //trip-payment api
/*
    public Payment addPaymentToTrip(Long tripId, Long paymentId) {
        Trip1 trip1 = trip1Repository.findById(tripId).orElse(null);
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        payment.addPaymentToTrip(trip1);
        return paymentRepository.save(payment);
    }

 */


}
