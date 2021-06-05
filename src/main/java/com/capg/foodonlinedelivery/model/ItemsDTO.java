package com.capg.foodonlinedelivery.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.entities.Restaurant;

public class ItemsDTO {

private Integer itemId;
private String itemName;
private Category category;
private Integer quantity;
private double cost;
private List<RestaurantDTO> restaurant=new ArrayList<>();



public ItemsDTO() {
	super();
}
public ItemsDTO(Integer itemId, String itemName, Category category, Integer quantity, double cost,
		List<RestaurantDTO> restaurant) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.category = category;
	this.quantity = quantity;
	this.cost = cost;
	this.restaurant = restaurant;
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
public List<RestaurantDTO> getRestaurant() {
	return restaurant;
}
public void setRestaurant(List<RestaurantDTO> restaurant) {
	this.restaurant = restaurant;
}

}
