package com.easyCarpool.project.trip;

import com.easyCarpool.project.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * this interface is the repository of trip , we use it to save data and get data from the data base
 */
public interface TripRepository extends JpaRepository<Trip,Long> {

}
