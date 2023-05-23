package com.easyCarpool.project.trip;


import com.easyCarpool.project.payment.Payment;
import com.easyCarpool.project.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

/**
 * this class represent a trip entity in database in ride share app
 */
@Entity(name = "trips")
@Table(
        name="trips"
)


public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name= "trip_id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "origin",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String origin;
    @Column(
            name = "destination",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String destination;

    @Column(
            name = "start_hour",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String startHour;

    @Column(
            name = "distance",
            nullable = false
    )
    private double distance;
    @Column(
            name = "start_date",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String startDate;


    @Column(
            name = "driver_id"
    )
    private Long driverId;
    @Column(
            name = "passengerCapacity",
            nullable = false
    )
    private Integer passengerCapacity;
    @Column(
            name = "passengerCounter",
            nullable = false
    )
    private Integer passengerCounter;
    @JsonIgnore
    @ManyToMany(mappedBy ="trips" )
    private Set<User> seats = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "trip")
    private Set<Payment> payments= new HashSet<>();

    /**
     * constructor
     */
    public Trip()
    {

    }
    /**
     * constructor
     * @param origin
     * @param destination
     * @param startHour
     * @param distance
     * @param startDate
     * @param driverId
     * @param passengerCapacity
     * @param passengerCounter
     */
    public Trip(String origin, String destination, String startHour, double distance, String startDate, Long driverId, int passengerCapacity, int passengerCounter) {
        this.origin = origin;
        this.destination = destination;
        this.startHour = startHour;
        this.distance = distance;
        this.startDate = startDate;
        this.driverId = driverId;
        this.passengerCapacity = passengerCapacity;
        this.passengerCounter = 0;
    }

    /***
     *
     * @return trip id
     */
    public Long getId() {
        return id;
    }

    /***
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /***
     *
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /***
     * set origin
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /***
     *
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /***
     *
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /***
     * this method return a set of available seats (users) in trip
     * @return seats
     */
    public Set<User> getSeats() {
        return seats;
    }

    /***
     *
     * @param seats
     */
    public void setSeats(Set<User> seats) {
        this.seats = seats;
    }


    /***
     *
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /***
     *
     * @return passenger counter
     */
    public int getPassengerCounter() {
        return passengerCounter;
    }

    /***
     *
     * @param passengerCounter
     */
    public void setPassengerCounter(int passengerCounter) {
        this.passengerCounter = passengerCounter;
    }

    /***
     *
     * @return capacity of passenger in a trip
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /***
     *
     * @param passengerCapacity
     */
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    /***
     *
     * @return payments of users for a trip
     */
    public Set<Payment> getPayments() {
        return payments;
    }

    /***
     *
     * @return start hour
     */
    public String getStartHour() {
        return startHour;
    }

    /***
     *
     * @param startHour
     */
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    /***
     *
     * @return start date
     */
    public String getStartDate() {
        return startDate;
    }

    /***
     *
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /***
     *
     * @param payments
     */
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    /***
     *
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /***
     *
     * @return driver id
     */
    public Long getDriverId() {
        return driverId;
    }

    /***
     *
     * @param driverId
     */
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    /***
     * this method add user to trip in a hashmap data structure
     * @param user
     */
    public void addUser(User user)
    {
        seats.add(user);
    }

    /***
     * this method remove a user from trip
     * @param user
     */
    public void removeUser(User user)
    {
        seats.remove(user);
    }

    /***
     * this method add payment from a user to payment data structure
     * @param payment
     */
    public void addPayment(Payment payment)
    {
        payments.add(payment);
    }



}
