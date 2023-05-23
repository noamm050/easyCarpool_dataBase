package com.easyCarpool.project.user;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * this interface is the repository of user , we use it to save data and get data from the data base
 */
public interface UserRepository extends JpaRepository<User,Long> {


}
