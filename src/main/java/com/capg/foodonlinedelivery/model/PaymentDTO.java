package com.capg.foodonlinedelivery.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.capg.foodonlinedelivery.entities.OrderDetails;

public class PaymentDTO {

	private String paymentId;
	private LocalDateTime paymentDate;
	private OrderDetails order;
	private Integer totalItem;
	private Double totalCost;

	public PaymentDTO() {
		super();
	}

	public PaymentDTO(String paymentId, LocalDateTime paymentDate, OrderDetails order, Integer totalItem,
			Double totalCost) {
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
