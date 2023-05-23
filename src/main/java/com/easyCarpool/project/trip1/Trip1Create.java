package com.easyCarpool.project.trip1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trip1Create {
/*
    @NotNull(message="origin cannot be empty ")
    private String origin;
    @NotNull(message="destination cannot be empty ")
    private String destination;

    @NotNull(message="start Hour cannot be empty ")
    private String startHour;

    @NotNull(message="destination cannot be empty ")
    private double distance;

    @NotNull(message="driver id cannot be empty ")
    private Long driverId;
    @NotNull(message="passenger capacity cannot be empty ")
    private Integer passengerCapacity;
    private Integer passengerCounter;

    @NotNull(message="start date cannot be empty ")
    private String startDate;
    public Trip1Create()
    {

    }

    public Trip1Create(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Trip1Create(String origin, String destination, String startHour, double distance, Long driverId, int passengerCapacity, String startDate) {
        this.origin = origin;
        this.destination = destination;
        this.startHour = startHour;
        this.distance = distance;
        this.driverId = driverId;
        this.passengerCapacity = passengerCapacity;
        this.startDate = startDate;
        passengerCounter=0;
    }

    public Trip1Create(String origin, String destination, String startHour, double distance, Long driverId, int passengerCapacity, int passengerCounter, String startDate) {
        this.origin = origin;
        this.destination = destination;
        this.startHour = startHour;
        this.distance = distance;
        this.driverId = driverId;
        this.passengerCapacity = passengerCapacity;
        this.passengerCounter = passengerCounter;
        this.startDate = startDate;
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCounter() {
        return passengerCounter;
    }

    public void setPassengerCounter(int passengerCounter) {
        this.passengerCounter = passengerCounter;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


 */
}
