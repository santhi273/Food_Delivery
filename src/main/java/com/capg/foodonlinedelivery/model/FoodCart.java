package com.capg.foodonlinedelivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FoodCart {
	@Id
private String cartId;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="item_id")
private List<Items> itemList;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="customer_id")
private Customer customer;
	
	public FoodCart() {
		super();
	}
	public FoodCart(String cartId, List<Items> itemList, Customer customer) {
		super();
		this.cartId = cartId;
		this.itemList = itemList;
		this.customer = customer;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public List<Items> getItemList() {
		return itemList;
	}
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}