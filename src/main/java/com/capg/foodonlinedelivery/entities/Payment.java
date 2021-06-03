package com.capg.foodonlinedelivery.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	@Id
private String paymentId;
private LocalDateTime paymentDate;
@OneToOne(cascade=CascadeType.ALL)
@JoinTable(name="order_id")
private OrderDetails order;
private Integer totalItem;
private Double totalCost;




public Payment() {
	super();
}
public Payment(String paymentId, LocalDateTime paymentDate, OrderDetails order, Integer totalItem, Double totalCost) {
	super();
	this.paymentId = paymentId;
	this.paymentDate = paymentDate;
	this.order = order;
	this.totalItem = totalItem;
	this.totalCost = totalCost;
}
public String getPaymentId() {
	return paymentId;
}
public void setPaymentId(String paymentId) {
	this.paymentId = paymentId;
}
public LocalDateTime getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(LocalDateTime paymentDate) {
	this.paymentDate = paymentDate;
}
public OrderDetails getOrder() {
	return order;
}
public void setOrder(OrderDetails order) {
	this.order = order;
}
public Integer getTotalItem() {
	return totalItem;
}
public void setTotalItem(Integer totalItem) {
	this.totalItem = totalItem;
}
public Double getTotalCost() {
	return totalCost;
}
public void setTotalCost(Double totalCost) {
	this.totalCost = totalCost;
}

}
