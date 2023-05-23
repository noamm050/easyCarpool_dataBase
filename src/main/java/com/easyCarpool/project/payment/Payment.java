package com.easyCarpool.project.payment;

import com.easyCarpool.project.trip.Trip;
import com.easyCarpool.project.trip1.Trip1;
import jakarta.persistence.*;

/***
 * this class represent payment in a database in ride share app
 */
@Entity(name = "payments")
@Table(
        name="payments"
)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name= "payment_id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "from_id",
            nullable = false
    )
    private Long fromId;
    @Column(
            name = "to_id",
            nullable = false
    )
    private Long toId;
    @Column(
            name = "amount",
            nullable = false
    )
    private double amount;
    @Column(
            name = "trip_id",
            nullable = false
    )
    private Long tripId;
    /*@ManyToOne
    @JoinColumn(name = "trip_information",referencedColumnName = "trip_id")
    private Trip1 trip1;
*/
    @ManyToOne
    @JoinColumn(name = "trip_information",referencedColumnName = "trip_id")
    private Trip trip;

    /***
     * constructor
     */
    public Payment()
    {

    }

    /***
     * constructor
     * @param fromId
     * @param toId
     * @param amount
     * @param tripId
     */
    public Payment(Long fromId, Long toId, double amount, Long tripId) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.tripId = tripId;
    }

   /* public Payment(Long fromId, Long toId, double amount, Long tripId, Trip1 trip1) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.tripId = tripId;
        this.trip1 = trip1;
    }
*/

    /***
     * constructor
     * @param fromId
     * @param toId
     * @param amount
     * @param tripId
     * @param trip
     */
    public Payment(Long fromId, Long toId, double amount, Long tripId, Trip trip) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.tripId = tripId;
        this.trip = trip;
    }

    /***
     * constructor
     * @param id
     * @param fromId
     * @param toId
     * @param amount
     * @param tripId
     */
    public Payment(Long id, Long fromId, Long toId, double amount, Long tripId) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.tripId = tripId;
    }

    /***
     *
      * @return id
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
     * return id of the user that pays for the trip
     * @return fromId
     */
    public Long getFromId() {
        return fromId;
    }

    /***
     *
     * @param fromId
     */
    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    /***
     * return the id of the user that receives from the trip
     * @return toId
     */
    public Long getToId() {
        return toId;
    }

    /***
     *
     * @param toId
     */
    public void setToId(Long toId) {
        this.toId = toId;
    }

    /***
     *
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /***
     *
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /***
     *
     * @return tripId
     */
    public Long getTripId() {
        return tripId;
    }

    /***
     *
     * @param tripId
     */
    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    /***
     *
     * @return trip
     */
    public Trip getTrip() {
        return trip;
    }

    /***
     *
     * @param trip
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
/*
    public Trip1 getTrip1() {
        return trip1;
    }

    public void setTrip1(Trip1 trip1) {
        this.trip1 = trip1;
    }
    */

    /***
     * this method add payment to trip
     * @param trip
     */
    public void addPaymentToTrip(Trip trip)
    {
        this.trip= trip;
    }
    /*
    public void addPaymentToTrip(Trip1 trip1)
    {
        this.trip1= trip1;
    }
    */

}


