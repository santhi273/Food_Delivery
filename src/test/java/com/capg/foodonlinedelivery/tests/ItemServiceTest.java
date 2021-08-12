package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.Address;
import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.repository.IItemRepository;

@SpringBootTest
public class ItemServiceTest {
	
	@Autowired
	IItemRepository repository;

	@Test
	void testAddItems() {
		
		Items item =repository.save(getItem());
		assertNotNull(item);
	}

	@Test
	void testUpdateItems() {
		Items item =repository.save(getItem());
		assertNotNull(item);
	}

	@Test
	void testRemoveItems() {
		
		repository.deleteById(8);
	}

	@Test
	void testFindItemsByRestaurant() {
		List<Items> list=repository.findByRestaurantList_RestaurantName("Savali");
		assertNotNull(list);
	}

	@Test
	void testViewAllItemsByCategory() {
	
		List<Items> list = repository.findItemsByCategory("Veg");
		assertNotNull(list);

	}

	

	@Test
	void testViewItemsById() {
		Items item=repository.findById(8).orElse(null);
		assertNotNull(item);
	}

	public Items getItem()
	{
		Items item=new Items();
		item.setItemId(1);
		item.setItemName("Paneer");
		item.setQuantity(2);
		item.setCost(200.00);
		item.setCategory(getCategory());
		item.setRestaurantList(getRestaurant());
		return item;
		
	}
		
		public List<Restaurant> getRestaurant()
		{
			List<Restaurant> restaurant=new ArrayList<Restaurant>();
			restaurant.get(0).getRestaurantId();
			restaurant.get(0).getRestaurantName();
			restaurant.get(0).getManagerName();
			restaurant.get(0).getPhoneNumber();
			restaurant.get(0).getAddress();
			restaurant.get(0).getItemList();
			return restaurant;
		}
		
		public Category getCategory()
		{
			Category category = new Category();
			category.setCategoryId(12);
			category.setCategoryName("Veg");
			return category;
		}
		
		public Address getAddress()
		{
			Address address=new Address();
			address.setAddressId(null);
			address.setdNo(null);
			address.setArea("Hadapsar");
			address.setCity("Pune");
			address.setState("AndhraPradesh");
			address.setPinCode(511511);;
			address.setCountry("India");
			return address;
		}


}
