package com.easyCarpool.project.user;

import com.easyCarpool.project.trip.Trip;
import com.easyCarpool.project.trip.Trip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/***
 * this class represent a user in database in ride share app
 */
@Entity(name = "users")
@Table(
        name="users"
)
public class User {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name= "n",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;
    @Column(
            name = "paid"
    )
    private double paid;
    @Column(
            name = "received"
    )
    private double received;

    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "passengers")
    private Set<Trip> trips=new HashSet<>();
*/
    @ManyToMany
    @JoinTable(
            name="user_in_trip",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name = "trip_id")}
    )
    private Set<Trip> trips=new HashSet<>();

    /***
     * constructor
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    public User(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /***
     * constructor
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /***
     * constructor
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param paid
     * @param received
     */
    public User(String firstName, String lastName, String email, String password, double paid, double received) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.paid = paid;
        this.received = received;
    }

    /***
     * constructor
     */
    public User() {

    }

    /***
     * id of user
     * @return id
     */
    public Long getId() {
        return id;
    }

    /***
     * set id of user
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /***
     * fisrt name of user
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /***
     * set first name of user
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /***
     * last name of user
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /***
     * set last name of user
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /***
     * email of user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /***
     * set email of user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /***
     * password of user
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /***
     * password of user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /***
     * amount of money the user had paid other users
     * @return paid
     */
    public double getPaid() {
        return paid;
    }

    /***
     * set amount of money the user had paid other users
     * @param paid
     */
    public void setPaid(double paid) {
        this.paid = paid;
    }

    /***
     * amount of money the user had received from other users
     * @return received
     */
    public double getReceived() {
        return received;
    }

    /***
     * set amount of money the user had received from other users
     * @param received
     */
    public void setReceived(double received) {
        this.received = received;
    }

    /*
        public  void addTrip(Trip trip){

            trips.add(trip);
        }
        */

    /***
     * add trip to list of trips of a given user
     * @param trip
     */
    public  void addTrip(Trip trip){

        trips.add(trip);
    }
    /*
    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
    */

    /***
     * list of trips
     * @return trips
     */
    public Set<Trip> getTrips() {
        return trips;
    }

    /***
     * set list of trips
     * @param trips
     */
    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    /***
     * remove trip from list
     * @param trip
     */
    public  void removeTrip(Trip trip){

        trips.remove(trip);
    }

    /***
     * to string of user info
     * @return user info
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
