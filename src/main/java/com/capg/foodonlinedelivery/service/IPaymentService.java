package com.capg.foodonlinedelivery.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.model.PaymentDTO;

public interface IPaymentService {
	public PaymentDTO updatePayment(Payment payment);
	public void removePayment(Payment payment);
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId);
	public List<PaymentDTO> viewPayment(LocalDate startDate,LocalDate endDate);
	public PaymentDTO viewPaymentById(String paymentId);
	public Double calculateTotalCost(Payment payment);
	public PaymentDTO addPayment(OrderDetails order);
}
