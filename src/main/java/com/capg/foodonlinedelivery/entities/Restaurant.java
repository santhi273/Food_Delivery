package com.capg.foodonlinedelivery.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
/**
 * 
 * @author: hemalatha
 * Description:restaurant Entity
 * date: 3/6/2021
 *
 */
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(generator="restaurant_seq",strategy=GenerationType.SEQUENCE)
	private Integer restaurantId;
	private String restaurantName;
	private String managerName;
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="restaurant_items",joinColumns=@JoinColumn(name="restaurant_id"),inverseJoinColumns=@JoinColumn(name="item_id"))
	private List<Items> itemList;

	public Restaurant() {
		super();
	}

	public Restaurant(Integer restaurantId, String restaurantName, String managerName, String phoneNumber,
			Address address, List<Items> itemList) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.itemList = itemList;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

}
