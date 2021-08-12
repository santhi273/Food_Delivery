package com.capg.foodonlinedelivery.model;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.Items;

import org.springframework.stereotype.Component;

@Component

public class FoodCartDTO {
	private Integer cartId;
	private List<Items> itemList;
	private Customer customer;

	public FoodCartDTO() {
		super();
	}

	public FoodCartDTO(Integer cartId, List<Items> itemList, Customer customer) {
		super();
		this.cartId = cartId;
		this.itemList = itemList;
		this.customer = customer;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
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
