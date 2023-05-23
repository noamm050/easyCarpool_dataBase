package com.easyCarpool.project.payment;

import jakarta.validation.constraints.NotNull;

/***
 * this class represent payment
 */
public class PaymentCreate {

    @NotNull(message="from cannot be null ")
    private Long fromId;
    @NotNull(message="to cannot be empty ")
    private Long toId;
    @NotNull(message="amount cannot be empty ")
    private double amount;
    @NotNull(message="trip cannot be empty ")
    private Long tripId;

    /***
     * constructor
     */
    public PaymentCreate()
    {}

    /***
     * constructor
     * @param fromId
     * @param toId
     * @param amount
     * @param tripId
     */
    public PaymentCreate(Long fromId, Long toId, double amount, Long tripId) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.tripId = tripId;
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
     * return id of the user that receives from a trip
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
}
