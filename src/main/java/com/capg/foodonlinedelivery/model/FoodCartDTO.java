package com.capg.foodonlinedelivery.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.Items;

public class FoodCartDTO {
	
    private String cartId;
    private List<ItemsDTO> itemList;
    private Customer customer;
	
	public FoodCartDTO() {
		super();
	}
	public FoodCartDTO(String cartId, List<ItemsDTO> itemList, Customer customer) {
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
	public List<ItemsDTO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemsDTO> itemList) {
		this.itemList = itemList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
