package com.capg.foodonlinedelivery.model;

import java.time.LocalDateTime;
import javax.validation.constraints.Digits;

import com.capg.foodonlinedelivery.entities.OrderDetails;

public class PaymentDTO {

	private Integer paymentId;
	private LocalDateTime paymentDate;
	private OrderDetails order;
	@Digits(fraction = 0, integer = 3)
    private Integer totalItem;
	private Double totalCost;

	public PaymentDTO() {
		super();
	}

	public PaymentDTO(Integer paymentId, LocalDateTime paymentDate, OrderDetails order, Integer totalItem,
			Double totalCost) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.order = order;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
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
