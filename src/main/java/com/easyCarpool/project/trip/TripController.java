package com.easyCarpool.project.trip;


import com.easyCarpool.project.user.User;
import com.easyCarpool.project.user.UserCreate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * this class represent the controller of a trip
 */
@RestController
@RequestMapping(path="api/v1/trip")
public class TripController {

    private TripService tripService;

    /***
     * constructor
     * @param tripService
     */
    @Autowired
    public TripController(TripService tripService) {
        this.tripService=tripService;
    }

    /***
     * this method create trip
     * @param trip
     * @return trip
     */
    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE
    },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<Trip> createTrip(@Valid @RequestBody TripCreate trip) {
        Trip savedTrip = new Trip();
        savedTrip.setOrigin(trip.getOrigin());
        savedTrip.setDestination(trip.getDestination());
        savedTrip.setStartHour(trip.getStartHour());
        savedTrip.setDistance(trip.getDistance());
        savedTrip.setDriverId(trip.getDriverId());
        savedTrip.setPassengerCapacity(trip.getPassengerCapacity());
        savedTrip.setPassengerCounter(0);
        savedTrip.setStartDate(trip.getStartDate());

        tripService.createTrip(savedTrip);
        return new ResponseEntity<Trip>(savedTrip, HttpStatus.OK);
    }

    /***
     * this method return a list of trips
     * @return trips
     */
    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        List<Trip> trips = tripService.getAllTrips();
        return ResponseEntity.ok(trips);
    }

    /***
     * this method delete trip
     * @param id
     * @return http response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }

    /***
     * this method add payment to trip
     * @param tripId
     * @param paymentId
     * @return http response
     */
    @PutMapping(path ="/{tripId}/paymentForTrip/{paymentId}")
    public ResponseEntity<Trip> addPaymentToTrip(@PathVariable Long tripId, @PathVariable Long paymentId) {
        tripService.addPaymentToTrip(tripId,paymentId);
        return new ResponseEntity<Trip>(HttpStatus.OK);
    }

}
