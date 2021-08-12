package com.capg.foodonlinedelivery.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.Payment;
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

	public List<Payment> findByOrderCustomerCustomerId(int customerId);

	public Payment findByorder_OrderId(int orderId);

}
