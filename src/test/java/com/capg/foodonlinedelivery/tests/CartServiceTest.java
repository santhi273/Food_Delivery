package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.Address;
import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.repository.ICartRepository;

@SpringBootTest
class CartServiceTest {
	
	@Autowired
	ICartRepository repository;

	@Test
	void testIncreaseQuantity() {
		
		FoodCart cart=getCart();
		List<Items> list=cart.getItemList();
		int size1=list.size();
		Items item=new Items();
		item.setItemId(5);
		item.setItemName("FrenchFries");
		item.setQuantity(2);
		item.setCost(200);
		item.setRestaurantList(getRestaurant());
		item.setCategory(getCategory());
		list.add(item);
		int size2=list.size();
		boolean r;
		if(size1<size2)
		{
			r=true;
		}
		else
		{
			r=false;
		}
		assertTrue(r);
	}

	@Test
	void testReduceQuantity() {
		
		FoodCart cart=getCart();
		List<Items> list=cart.getItemList();
		int size1=list.size();
		list.remove(0);
		int size2=list.size();
		boolean r;
		if(size1>size2)
		{
			r=true;
		}
		else
		{
			r=false;
		}
		assertTrue(r);
	}

	@Test
	void testRemoveItem() {

		FoodCart cart=getCart();
		List<Items> list=cart.getItemList();
		int size1=list.size();
		list.remove(0);
		int size2=list.size();
		boolean r;
		if(size1>size2)
		{
			r=true;
		}
		else
		{
			r=false;
		}
		assertTrue(r);
	}
	public FoodCart getCart()
	{
		FoodCart cart=new FoodCart();
		cart.setCartId(1);
		cart.setCustomer(getCustomer());
		List<Items> list=new ArrayList<Items>();
		list.add(getItemList());
		cart.setItemList(list);;
		return cart;
	}
	
	public Customer getCustomer()
	{
		Customer customer=new Customer();
		customer.setAddress(getAddress());
		customer.setCustomerId(10);
		customer.setEmailId("Amit@gmail.com");
		customer.setFirstName("Amit");
		customer.setGender("M");
		customer.setLastName("Shinde");
		customer.setPhoneNumber("9876543218");
		return customer;
	}
	
	
	public Address getAddress()
	{
		Address address=new Address();
		address.setAddressId(12);
		address.setdNo(32);
		address.setArea("Hadapsar");
		address.setCity("Pune");
		address.setState("AndhraPradesh");
		address.setPinCode(511511);;
		address.setCountry("India");
		return address;
	}
	
	public List<Restaurant> getRestaurant()
	{
		List<Restaurant> restaurant=new ArrayList<Restaurant>();
		Restaurant restaurant1=new Restaurant();
		restaurant1.setRestaurantId(12);
		restaurant1.setRestaurantName("anapurana");
		restaurant1.setManagerName("santhi");
		restaurant1.setPhoneNumber("1234567890");
		restaurant1.setAddress(getAddress());
		restaurant1.setItemList(null);;
		restaurant.add(restaurant1);
		return restaurant;
	}
	
	public Category getCategory()
	{
		Category category = new Category();
		category.setCategoryId(12);
		category.setCategoryName("Veg");
		return category;
	}
	
	public Items getItemList()
	{
		Items item=new Items();
		item.setItemId(1);
		item.setItemName("Paneer");
		item.setQuantity(2);
		item.setCost(200.00);
		item.setCategory(getCategory());
		item.setRestaurantList((List<Restaurant>) getRestaurant());
		return item;
	}


}
