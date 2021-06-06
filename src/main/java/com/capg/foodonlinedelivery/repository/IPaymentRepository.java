package com.capg.foodonlinedelivery.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.foodonlinedelivery.entities.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, String> {
	@Query("select payment from Payment paymemt " + "JOIN OrderDetails order "
			+ "ON payment.order.orderId=oorder.orderId " + "WHERE order.customer.customerId =:custId")
	List<Payment> findByCustId(@Param("customerId") int customerId);

	@Query("select payment  from Payment payment where payment.paymentDate BETWEEN ?1 AND ?2")
	public List<Payment> findByPaymentDates(LocalDateTime start, LocalDateTime end);

}
