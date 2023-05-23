package com.easyCarpool.project.trip;

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

/***
 * this class represent trip
 */
public class TripCreate {

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

    /***
     * constructor
     */
    public TripCreate()
    {

    }

    /***
     * constructor
     * @param origin
     * @param destination
     */
    public TripCreate(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    /***
     * constructor
     * @param origin
     * @param destination
     * @param startHour
     * @param distance
     * @param driverId
     * @param passengerCapacity
     * @param startDate
     */
    public TripCreate(String origin, String destination, String startHour, double distance, Long driverId, int passengerCapacity, String startDate) {
        this.origin = origin;
        this.destination = destination;
        this.startHour = startHour;
        this.distance = distance;
        this.driverId = driverId;
        this.passengerCapacity = passengerCapacity;
        this.startDate = startDate;
        passengerCounter=0;
    }

    /***
     * constructor
     * @param origin
     * @param destination
     * @param startHour
     * @param distance
     * @param driverId
     * @param passengerCapacity
     * @param passengerCounter
     * @param startDate
     */
    public TripCreate(String origin, String destination, String startHour, double distance, Long driverId, int passengerCapacity, int passengerCounter, String startDate) {
        this.origin = origin;
        this.destination = destination;
        this.startHour = startHour;
        this.distance = distance;
        this.driverId = driverId;
        this.passengerCapacity = passengerCapacity;
        this.passengerCounter = passengerCounter;
        this.startDate = startDate;
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
     *
     * @return passenger capacity
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
     * @return passenger Counter
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
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /***
     *
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
