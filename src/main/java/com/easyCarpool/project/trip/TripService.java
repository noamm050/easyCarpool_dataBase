package com.easyCarpool.project.trip;


import com.easyCarpool.project.payment.Payment;
import com.easyCarpool.project.payment.PaymentRepository;
import com.easyCarpool.project.user.User;
import com.easyCarpool.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * this class is the service class of trip , we use it to allow the user to get info and save info , its part of the architecture
 */
@Service
public class TripService {


    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    /***
     *  this method create trip
     * @param trip
     * @return trip
     */
    public Trip createTrip(Trip trip) {

        // Save User to database
        tripRepository.save(trip);
        return trip;
    }

    /***
     * this method retuen list of trips
     * @return tripEntities
     */
    public List<Trip> getAllTrips() {
        // Find all UserEntities
        List<Trip> tripEntities = tripRepository.findAll();

        return tripEntities;
    }

    /***
     * this methos delete trips
     * @param id
     */
    public void deleteTrip(Long id) {
        // Delete UserEntity by ID
        tripRepository.deleteById(id);
    }

    //user-trip api

    /***
     * this method add user to trip
     * @param tripId
     * @param userId
     * @return trip
     */
    public Trip addUserToTrip(Long tripId, Long userId) {
        Trip trip = tripRepository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        trip.addUser(user);
        trip.setPassengerCounter(trip.getPassengerCounter()+1);
        return tripRepository.save(trip);
    }

    /***
     * this method remove User From Trip
     * @param tripId
     * @param userId
     * @return trip
     */
    public Trip  removeUserFromTrip(Long tripId, Long userId) {
        Trip trip = tripRepository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        trip.removeUser(user);
        return tripRepository.save(trip);
    }

    /***
     * this method add driver to trip
     * @param tripId
     * @param userId
     * @return trip
     */
    public Trip  addDriverToTrip(Long tripId, Long userId) {
        Trip trip = tripRepository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        trip.setDriverId(user.getId());
        return tripRepository.save(trip);
    }


    //trip-payment api

    /***
     * this method add payment to trip
     * @param tripId
     * @param paymentId
     * @return payment
     */
    public Payment addPaymentToTrip(Long tripId, Long paymentId) {
        Trip trip = tripRepository.findById(tripId).orElse(null);
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        payment.addPaymentToTrip(trip);
        return paymentRepository.save(payment);
    }

}
