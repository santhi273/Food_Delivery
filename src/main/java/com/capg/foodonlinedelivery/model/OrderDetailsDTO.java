package com.capg.foodonlinedelivery.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.capg.foodonlinedelivery.entities.FoodCart;

@Component
public class OrderDetailsDTO {
	
private Integer orderId;
private LocalDateTime orderDate;
private FoodCart cart;
private String orderStatus;

public OrderDetailsDTO() {
	super();
}
public OrderDetailsDTO(Integer orderId, LocalDateTime orderDate, FoodCart cart, String orderStatus) {
	super();
	this.orderId = orderId;
	this.orderDate = orderDate;
	this.cart = cart;
	this.orderStatus = orderStatus;
}
public Integer getOrderId() {
	return orderId;
}
public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}
public LocalDateTime getOrderDate() {
	return orderDate;
}
public void setOrderDate(LocalDateTime orderDate) {
	this.orderDate = orderDate;
}
public FoodCart getCart() {
	return cart;
}
public void setCart(FoodCart cart) {
	this.cart = cart;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

}
