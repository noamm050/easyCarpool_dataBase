package com.easyCarpool.project.trip1;

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
/*
@Entity
@Table(name="trips1")

 */
public class Trip1 {
    /*
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
    @OneToMany(mappedBy = "trip1")
    private Set<Payment> payments= new HashSet<>();

    public Trip1()
    {

    }

    public Trip1(String origin, String destination, String startHour, double distance, String startDate, Long driverId, int passengerCapacity, int passengerCounter) {
        this.origin = origin;
        this.destination = destination;
        this.startHour = startHour;
        this.distance = distance;
        this.startDate = startDate;
        this.driverId = driverId;
        this.passengerCapacity = passengerCapacity;
        this.passengerCounter = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Set<User> getSeats() {
        return seats;
    }

    public void setSeats(Set<User> seats) {
        this.seats = seats;
    }



    public double getDistance() {
        return distance;
    }

    public int getPassengerCounter() {
        return passengerCounter;
    }

    public void setPassengerCounter(int passengerCounter) {
        this.passengerCounter = passengerCounter;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public void addUser(User user)
    {
        seats.add(user);
    }

    public void removeUser(User user)
    {
        seats.remove(user);
    }
    public void addPayment(Payment payment)
    {
        payments.add(payment);
    }



     */
}
