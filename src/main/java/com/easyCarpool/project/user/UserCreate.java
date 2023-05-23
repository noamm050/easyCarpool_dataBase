package com.easyCarpool.project.user;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

/***
 * this class represent user
 */
public class UserCreate {

    /***
     * constructor
     */
    public UserCreate()
    {}

    /***
     * constructor
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param paid
     * @param received
     */
    public UserCreate(String firstName, String lastName, String email, String password, double paid, double received) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.paid = paid;
        this.received = received;
    }

    /***
     * constructor
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    public UserCreate(String firstName, String lastName, String email, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    @NotNull(message="first name cannot be empty ")
    private String firstName;
    @NotNull(message="last name cannot be empty")
    private String lastName;
    @NotNull(message="email cannot be empty")
    @Email
    private String email;
    @NotNull(message="password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    private double paid;
    private double received;

    /***
     *
     * @return paid
     */
    public double getPaid() {
        return paid;
    }

    /***
     *
     * @param paid
     */
    public void setPaid(double paid) {
        this.paid = paid;
    }

    /***
     *
     * @return received
     */
    public double getReceived() {
        return received;
    }

    /***
     *
     * @param received
     */
    public void setReceived(double received) {
        this.received = received;
    }

    /***
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /***
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /***
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /***
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /***
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /***
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /***
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /***
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
