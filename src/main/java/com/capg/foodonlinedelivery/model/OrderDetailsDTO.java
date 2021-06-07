package com.capg.foodonlinedelivery.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;
import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.Restaurant;

@Component
public class OrderDetailsDTO {

	
	private int orderId;
	private LocalDateTime OrderDate;
	private Customer customer;
    List<Items> list;
	Restaurant restaurant;

	
	private String orderStatus;

	public OrderDetailsDTO() {
		super();
	}

	public OrderDetailsDTO(int orderId, LocalDateTime orderDate, Customer customer, List<Items> list,
			String orderStatus) {
		super();
		this.orderId = orderId;
		OrderDate = orderDate;
		this.customer = customer;
		this.list = list;
		this.orderStatus = orderStatus;
	}

	public OrderDetailsDTO(LocalDateTime orderDate, Customer customer, List<Items> list,
			String orderStatus) {
		super();
		OrderDate = orderDate;
		this.customer = customer;
		this.list = list;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDateTime getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		OrderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> list) {
		this.list = list;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", OrderDate=" + OrderDate + ", customer=" + customer + ", list="
				+ list + ", orderStatus=" + orderStatus + "]";
	}
	
	

}
