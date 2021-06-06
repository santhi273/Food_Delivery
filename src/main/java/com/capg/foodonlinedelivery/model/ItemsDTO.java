package com.capg.foodonlinedelivery.model;
import java.util.List;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.entities.Restaurant;

public class ItemsDTO {

	private String itemId;
	private String itemName;
	private Category category;
	private Integer quantity;
	private double cost;
	private List<Restaurant> restaurantList;
	private Restaurant restaurant;

	public ItemsDTO() {
		super();
	}

	
	public ItemsDTO(String itemId, String itemName, Category category, Integer quantity, double cost,
			List<Restaurant> restaurantList, Restaurant restaurant) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurantList = restaurantList;
		this.restaurant = restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}


	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}


	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Restaurant getRestaurant() {
		return restaurant;
		
	}

	
}
