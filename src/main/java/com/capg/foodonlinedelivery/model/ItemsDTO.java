package com.capg.foodonlinedelivery.model;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.entities.Restaurant;
@Component
public class ItemsDTO {

	private Integer itemId;
	@NotBlank(message="Name should be required.")
	private String itemName;
	private Category category;
	@NotEmpty
	@Digits(fraction = 0, integer = 2)
	private Integer quantity;
	@Digits(fraction = 0, integer = 3)
	private double cost;
	private List<Restaurant> restaurantList;

	public ItemsDTO() {
		super();
	}

	
	public ItemsDTO(Integer itemId, String itemName, Category category, Integer quantity, double cost,
			List<Restaurant> restaurantList) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurantList = restaurantList;
	
	}


	

	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}


	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}


	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
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

	
	
}
