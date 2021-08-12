package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.Address;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;

@SpringBootTest
public class RestauarantServiceTest {
	@Autowired
	IRestaurantRepository repository;
	
	@Test
	void testAddRestaurant() {
		
		Restaurant restaurant=repository.save(null);
		assertNotNull(restaurant);
	}

	@Test
	void testUpdateRestaurant() {

		Restaurant restaurant=repository.save(null);
		assertNotNull(restaurant);
	}
	@Test
	void testRemoveRestaurantById() {
		repository.deleteById(null);
		assertNotNull("Restaurant removed Succesfully");
	}
	@Test
	void testViewRestaurant() {

		List<Restaurant> restaurant=repository.findAll();
		assertNotNull(restaurant);
	}

	@Test
	void testViewRestaurantByItemName() {

		List<Restaurant> restaurants=repository.findByItemList_ItemName("Paneer");
		assertNotNull(restaurants);
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

}



