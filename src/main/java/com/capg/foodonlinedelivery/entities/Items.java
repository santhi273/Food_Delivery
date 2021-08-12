package com.capg.foodonlinedelivery.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author: venkatesh
 * Description:Items Entity
 * date: 3/6/2021
 *
 */
@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer itemId;
	private String itemName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	private Integer quantity;
	private double cost;
	@JsonIgnore
	@ManyToMany(mappedBy="itemList")
	private List<FoodCart> cart;
	@JsonIgnore
	@ManyToMany(mappedBy="itemList",cascade=CascadeType.ALL)
	private List<Restaurant> restaurantList;


	public List<FoodCart> getCart() {
		return cart;
	}

	public void setCart(List<FoodCart> cart) {
		this.cart = cart;
	}

	public Items() {
		super();
	}

	public Items(Integer itemId, String itemName, Category category, Integer quantity, double cost,
			List<Restaurant> restaurantList) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
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

	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", quantity="
				+ quantity + ", cost=" + cost + ", cart=" + cart + ", restaurantList=" + restaurantList + "]";
	}

}
