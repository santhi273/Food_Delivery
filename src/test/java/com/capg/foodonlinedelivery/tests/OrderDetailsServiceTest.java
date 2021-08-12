package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.Address;
import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.repository.IOrderRepository;

@SpringBootTest
public class OrderDetailsServiceTest {
	@Autowired
	IOrderRepository repository;
	
	@Test
	void testAddOrder() {
		OrderDetails order=repository.save(getOrder());
		assertNotNull(order);
	}

	@Test
	void testUpdateOrder() {
		OrderDetails order=repository.save(getOrder());
		assertNotNull(order);
	}


	@Test
	void testViewOrderById() {
		OrderDetails order=repository.findById(11);
		assertNotNull(order);
	}

	@Test
	void testViewAllOrdersByCustomer() {
		List<OrderDetails> list=repository.findAllOrdersByCustomer(10);
		int cnt=list.size();
		boolean res=false;
		if(cnt==0)
		{
			res=true;
		}
		assertTrue(res);
		}

	@Test
	void testViewAllOrdersByRestaurant() {
		List<OrderDetails> list=repository.findAllByRestaurant("Annapurna");
		assertNotNull(list);

	}
	@Test
	void testRemoveOrderById() {
		repository.deleteById(11);
		
	}

	public Customer getCustomer()
	{
		Customer cust=new Customer();
		cust.setCustomerId(10);
		cust.setFirstName("hema");
		cust.setLastName("Shinde");
		cust.setEmailId("hema20@gmail.com");
		cust.setPhoneNumber("987456242");
		cust.getAddress();
		cust.setGender("F");
		return cust;
	}
	public Address getAddress()
	{
		Address add=new Address();
		add.setAddressId(2);
		add.setArea("Miyapur");
		
		add.setCity("Hyderabad");
		add.setCountry("India");
		add.setPinCode(41160);
		add.setState("Telanagana");
		add.setdNo(93);
		return add;
	}
	public Restaurant getRestaurant()
	{
		Restaurant restaurant = new Restaurant();
		restaurant.getAddress();
		restaurant.setRestaurantId(4);
		restaurant.setRestaurantName("sitara Hotel");
		restaurant.setManagerName("Dhanashree");
		restaurant.setPhoneNumber("9876543210");
		restaurant.setItemList(null);
		return restaurant;
	}
	public OrderDetails getOrder()
	{
		OrderDetails ord=new OrderDetails();
		ord.setCustomer(getCustomer());
		ord.setList(null);
		ord.setOrderDate(LocalDateTime.now());
		ord.setOrderId(11);
		ord.setOrderStatus("delivered");
		ord.setRestaurant(getRestaurant());
		return ord;
	}
	
}


