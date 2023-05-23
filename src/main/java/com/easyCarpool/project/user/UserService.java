package com.easyCarpool.project.user;

import com.easyCarpool.project.trip.Trip;
import com.easyCarpool.project.trip.TripRepository;
import com.easyCarpool.project.trip.Trip;
import com.easyCarpool.project.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/***
 * this class is the service class
 */
@Service
public class UserService {

 @Autowired
    private UserRepository userRepository;
    //@Autowired
    //private TripRepository tripRepository;
    @Autowired
    private TripRepository tripRepository;

    /***
     * this method create user
     * @param user
     * @return user
     */
    public User createUser(User user) {

        // Save User to database
        userRepository.save(user);
        return user;
    }

    /***
     * this method get user
     * @param id
     * @return user
     */
    public User getUserById(Long id) {
        // Find User by ID
        Optional<User> userEntity = userRepository.findById(id);

        // Convert to User object
        User user = new User();
        user.setId(userEntity.get().getId());
        user.setFirstName(userEntity.get().getFirstName());
        user.setLastName(userEntity.get().getLastName());
        user.setEmail(userEntity.get().getEmail());
        user.setPassword(userEntity.get().getPassword());
        return user;
    }

    /***
     * this method delete user
     * @param id
     */
    public void deleteUser(Long id) {
        // Delete UserEntity by ID
        userRepository.deleteById(id);
    }
/*
    public User addTripToUser(Long tripId, Long userId) {
        Trip trip = tripRepository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        user.addTrip(trip);
        return userRepository.save(user);
    }
*/

    /***
     * this method update user
     * @param id
     * @param user
     * @return updatedUser
     */
    public User updateUser(Long id, User user) {
        // Find UserEntity by ID
        Optional<User> userEntity = userRepository.findById(id);

        // Update UserEntity with new User data
        userEntity.get().setFirstName(user.getFirstName());
        userEntity.get().setLastName(user.getLastName());
        userEntity.get().setEmail(user.getEmail());
        userEntity.get().setPassword(user.getPassword());

        // Save updated UserEntity to database
        User updatedUserEntity = userRepository.save(userEntity.get());

        // Convert UserEntity object to User object
        User updatedUser = new User();
        updatedUser.setId(updatedUserEntity.getId());
        updatedUser.setFirstName(updatedUserEntity.getFirstName());
        updatedUser.setLastName(updatedUserEntity.getLastName());
        updatedUser.setEmail(updatedUserEntity.getEmail());
        updatedUser.setPassword(updatedUserEntity.getPassword());

        return updatedUser;
    }

    /***
     *  this method return list of users
     * @return userEntities
     */
    public List<User> getAllUsers() {
        // Find all UserEntities
        List<User> userEntities = userRepository.findAll();

        return userEntities;
    }

    /***
     * this method add trip to user
     * @param tripId
     * @param userId
     * @return user
     */
    //user trip api
    public User addTripToUser(Long tripId, Long userId) {
        Trip trip = tripRepository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        user.addTrip(trip);
        return userRepository.save(user);
    }

    /***
     * this method remove trip from user
     * @param tripId
     * @param userId
     * @return user
     */
    public User removeTripFromUser(Long tripId, Long userId) {
        Trip trip = tripRepository.findById(tripId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        user.removeTrip(trip);
        return userRepository.save(user);
    }

    /***
     * this method updatre balance of user
     * @param amount
     * @param fromId
     * @param toId
     * @return recipientUser
     */
    // user payment api
   public User updateUserBalance(double amount,Long fromId, Long toId)
   {
       User payerUser = userRepository.findById(fromId).orElse(null);
       User recipientUser = userRepository.findById(toId).orElse(null);
       payerUser.setPaid(payerUser.getPaid()+amount);
       recipientUser.setReceived(recipientUser.getReceived()+amount);
       userRepository.save(payerUser);
       return userRepository.save(recipientUser);
   }

}
