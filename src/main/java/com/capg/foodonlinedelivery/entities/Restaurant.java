package com.capg.foodonlinedelivery.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(generator="restaurant_seq",strategy=GenerationType.SEQUENCE)
	private Integer restaurantId;
	private String restaurantName;
	private String managerName;
	private long phoneNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "address_id")
	private Address address;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private List<Items> itemList = new ArrayList<>();

	public Restaurant() {
		super();
	}

	public Restaurant(Integer restaurantId, String restaurantName, String managerName, long phoneNumber,
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
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
