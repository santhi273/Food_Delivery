package com.capg.foodonlinedelivery.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.foodonlinedelivery.entities.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);
	public Payment updatePayment(Payment payment);
	public Payment removePayment(Payment payment);
	public Payment viewPayment(Payment payment);
	public List<Payment> viewPaymentByCustomerId(int customerId);
	public List<Payment> viewPayment(LocalDate startDate,LocalDate endDate);
	public Payment calculateTotalCost(double payment);
}
