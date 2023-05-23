package com.easyCarpool.project.user;

import com.easyCarpool.project.trip.TripService;
import com.easyCarpool.project.trip1.Trip1Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * this class represent the controller class of a user
 */
@RestController
@RequestMapping(path="api/v1/user")
public class UserController {


    private UserService userService;
    @Autowired
    private TripService tripService;

    /***
     * constructor
     * @param userService
     */
    @Autowired
    public UserController(UserService userService){

        this.userService=userService;
    }


    /***
     * this method create user and return http status of user if the creation is ok or other status if something is wrong
     * @param user
     * @return savedUser
     */
    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE
    },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<User> createUser(@Valid@RequestBody UserCreate user) {
        User savedUser = new User();
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(user.getPassword());


        userService.createUser(savedUser);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    /***
     * this method get user and return http status of user if the call is ok or other status if something is wrong
     * @param id
     * @return user
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /***
     * this method delete user
     * @param id
     * @return no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /***
     * this method update user and return http status of user if the call is ok or other status if something is wrong
     * @param id
     * @param user
     * @return updatedUser
     */
    @PutMapping(path = "/{id}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
           produces = {
                   MediaType.APPLICATION_JSON_VALUE
           } )
    public ResponseEntity<User> updateUser(@PathVariable Long id,@Valid @RequestBody UserCreate user) {
        User updatedUser =new User();
        updatedUser.setId(id);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
                userService.updateUser(id, updatedUser);

        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }

    /***
     * this method returns list of users and return http status of user if the call is ok or other status if something is wrong
     * @return list of users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

  // user-trip api

    /***
     * this method add user to trip
     * @param tripId
     * @param userId
     * @return http Status
     */
  @PutMapping(path ="/{tripId}/users/{userId}")
  public ResponseEntity<User> userJoinTrip(@PathVariable Long tripId,@PathVariable Long userId) {
      tripService.addUserToTrip(tripId,userId);
      userService.addTripToUser(tripId,userId);
      return new ResponseEntity<User>(HttpStatus.OK);
  }

    /***
     * this method add driver to trip
     * @param tripId
     * @param userId
     * @return httpStatus
     */
    @PutMapping(path ="/{tripId}/set-driver/{userId}")
    public ResponseEntity<User> DriverJoinTrip(@PathVariable Long tripId,@PathVariable Long userId) {
        tripService.addDriverToTrip(tripId,userId);

        return new ResponseEntity<User>(HttpStatus.OK);
    }

    /***
     * this method remove user from trip
     * @param tripId
     * @param userId
     * @return httpStatus
     */
    @PutMapping(path ="/{tripId}/users-remove/{userId}")
    public ResponseEntity<User> userRemoveTrip(@PathVariable Long tripId,@PathVariable Long userId) {
        tripService.removeUserFromTrip(tripId,userId);
        userService.removeTripFromUser(tripId,userId);
        return new ResponseEntity<User>(HttpStatus.OK);
    }


}