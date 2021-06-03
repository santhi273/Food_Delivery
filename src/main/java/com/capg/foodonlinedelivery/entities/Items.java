package com.capg.foodonlinedelivery.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Items {
@Id
private Integer itemId;
private String itemName;
@OneToOne(cascade=CascadeType.ALL)
@JoinTable(name="category_id")
private Category category;
private Integer quantity;
private double cost;
@ManyToMany(fetch=FetchType.LAZY,mappedBy="Restaurant")
private List<Restaurant> restaurant;



public Items() {
	super();
}
public Items(Integer itemId, String itemName, Category category, Integer quantity, double cost,
		List<Restaurant> restaurant) {
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
public List<Restaurant> getRestaurant() {
	return restaurant;
}
public void setRestaurant(List<Restaurant> restaurant) {
	this.restaurant = restaurant;
}

}
