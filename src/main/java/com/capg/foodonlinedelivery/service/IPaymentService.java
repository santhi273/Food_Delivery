package com.capg.foodonlinedelivery.service;


import java.util.List;


import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.model.PaymentDTO;

public interface IPaymentService {
	public PaymentDTO updatePayment(Payment payment);
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId);
	
	public PaymentDTO viewPaymentById(Integer paymentId);
	public Double calculateTotalCost(Payment payment);
   public PaymentDTO addPayment(Integer orderId);



}
