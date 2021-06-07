package com.capg.foodonlinedelivery.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String itemId;
	@NotBlank(message="Name should be required.")
	private String itemName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "category_id")
	private Category category;
	@NotEmpty
	@Digits(fraction = 0, integer = 2)
	private Integer quantity;
	@Digits(fraction = 0, integer = 3)
	private double cost;
	@ManyToOne
	@JoinTable(name="Item_Id")
	private FoodCart cart;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "Items_Restaurant", joinColumns = { @JoinColumn(name = "item_id") }, inverseJoinColumns = {
			@JoinColumn(name = "restaurant_id") })
	private List<Restaurant> restaurantList = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Items() {
		super();
	}

	public Items(String itemId, String itemName, Category category, Integer quantity, double cost,
			List<Restaurant> restaurantList,Restaurant restaurant) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurantList = restaurantList;
		this.restaurant=restaurant;
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

	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

}
