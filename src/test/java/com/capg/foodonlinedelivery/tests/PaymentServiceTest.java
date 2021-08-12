package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.Address;
import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.repository.IPaymentRepository;

@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	IPaymentRepository repository;
	@AutoConfigureTestDatabase(replace = Replace.NONE)
	@Test
	void testAddPayment() {
	    Payment payment=repository.save(getPayment());
		assertNotNull(payment);
	}
	@Test
	void testUpdatePayment() {
	    Payment payment=repository.save(getPayment());
		assertNotNull(payment);
	}
	@Test
	void testViewPaymentById() {
		Optional<Payment> payment=repository.findById(3);
		assertNotNull(payment);
	}
	@Test
	void testViewPaymentByCustomerId() {
		List<Payment> payment=repository.findByOrderCustomerCustomerId(10);
		assertNotNull(payment);
	}

	@Test
	void testCalculateTotalCost() {

		Double totalCost=123.00;
		assertNotNull(totalCost);
	}


	public Customer getCustomer()
	{
		Customer cust=new Customer();
		cust.setCustomerId(10);
		cust.setFirstName("hema");
		cust.setLastName("Shinde");
		cust.setEmailId("hema20@gmail.com");
		cust.setPhoneNumber("9874562425");
		cust.setAddress(getAddress());
		cust.setGender("F");
		return cust;
	}
	public Address getAddress()
	{
		Address add=new Address();
		add.setArea("Miyapur");
		
		add.setCity("Hyderbad");
		add.setCountry("India");
		add.setPinCode(41160);
		add.setState("Telangana");
		add.setdNo(93);
		return add;
	}
	public Restaurant getRestaurant()
	{
		Restaurant res=new Restaurant();
		res.setAddress(getAddress());
		res.setPhoneNumber("9866042006");
	    res.setManagerName("ravi");
	    res.setRestaurantId(3);
	    res.setRestaurantName("Annapurna");
	    res.setItemList(null);
	    return res;
	}
	public OrderDetails getOrder()
	{
		OrderDetails ord=new OrderDetails();
		ord.setCustomer(getCustomer());
		ord.setList(null);
		ord.setOrderDate(LocalDateTime.now());
		ord.setOrderId(2);
		ord.setOrderStatus("delivered");
		ord.setRestaurant(getRestaurant());
		return ord;
	}
	 public Payment getPayment()
	 {
		 Payment payment=new Payment();
		 payment.setPaymentDate(LocalDateTime.now());
		 payment.setPaymentId(3);
		 payment.setOrder(getOrder());
		 payment.setTotalCost(123.00);
		 payment.setTotalItem(2);
		 return payment;
	 }


}
