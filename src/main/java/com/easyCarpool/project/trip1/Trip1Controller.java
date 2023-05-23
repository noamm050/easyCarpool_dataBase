package com.easyCarpool.project.trip1;


import com.easyCarpool.project.user.User;
import com.easyCarpool.project.user.UserCreate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
@RequestMapping(path="api/v1/trip1")

 */
public class Trip1Controller {
    /*

    private Trip1Service trip1Service;

    @Autowired
    public Trip1Controller(Trip1Service trip1Service) {
        this.trip1Service=trip1Service;
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE
    },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<Trip1> createTrip(@Valid @RequestBody Trip1Create trip1) {
        Trip1 savedTrip = new Trip1();
        savedTrip.setOrigin(trip1.getOrigin());
        savedTrip.setDestination(trip1.getDestination());
        savedTrip.setStartHour(trip1.getStartHour());
        savedTrip.setDistance(trip1.getDistance());
        savedTrip.setDriverId(trip1.getDriverId());
        savedTrip.setPassengerCapacity(trip1.getPassengerCapacity());
        savedTrip.setPassengerCounter(0);
        savedTrip.setStartDate(trip1.getStartDate());

       trip1Service.createTrip(savedTrip);
        return new ResponseEntity<Trip1>(savedTrip, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Trip1>> getAllTrips() {
        List<Trip1> trips = trip1Service.getAllTrips();
        return ResponseEntity.ok(trips);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        trip1Service.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path ="/{tripId}/paymentForTrip/{paymentId}")
    public ResponseEntity<Trip1> addPaymentToTrip(@PathVariable Long tripId, @PathVariable Long paymentId) {
        trip1Service.addPaymentToTrip(tripId,paymentId);
        return new ResponseEntity<Trip1>(HttpStatus.OK);
    }


     */
}
