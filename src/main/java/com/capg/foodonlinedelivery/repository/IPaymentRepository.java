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

	@Query("select payment  from Payment payment where payment.paymentDate BETWEEN ?1 AND ?2")
	public List<Payment> findByPaymentDates(LocalDateTime start, LocalDateTime end);

}
