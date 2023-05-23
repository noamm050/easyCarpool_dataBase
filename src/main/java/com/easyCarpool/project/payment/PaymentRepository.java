package com.easyCarpool.project.payment;

import com.easyCarpool.project.trip1.Trip1;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * this interface is the repository of payment , we use it to save data and get data from the data base
 */
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
