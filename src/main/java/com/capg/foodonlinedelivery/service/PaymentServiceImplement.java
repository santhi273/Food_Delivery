package com.capg.foodonlinedelivery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.model.PaymentDTO;
import com.capg.foodonlinedelivery.repository.IPaymentRepository;
import com.capg.foodonlinedelivery.utils.PaymentUtils;

@Service
public class PaymentServiceImplement implements IPaymentService {
	@Autowired
	IPaymentRepository repository;
	FoodCart foodcart;


	
	@Override
	public PaymentDTO addPayment(OrderDetails order) {
		Payment payment=new Payment();
		List<Items> list=order.getList();
		int totalItems=list.size();
		double sum=0.0;
		for(int i=0;i<totalItems;i++) {
			Items item=list.get(i);
			sum+=item.getCost();
		}
		payment.setPaymentDate(order.getOrderDate());
		payment.setOrder(order);
		payment.setTotalItem(totalItems);
		payment.setTotalCost(sum);
       Payment payment1=repository.save(payment);
        return PaymentUtils.convertToPaymentDto(payment1);
	}

	@Override
	public PaymentDTO updatePayment(Payment payment) {
		Payment payment1 = repository.save(payment);
		return  PaymentUtils.convertToPaymentDto(payment1);
	}

	@Override
	public void removePayment(Payment payment) {
		repository.delete(payment);
	}
   @Override
	public PaymentDTO viewPaymentById(String paymentId) {
		Payment payment1 = repository.findById(paymentId).orElse(null);
		return PaymentUtils.convertToPaymentDto(payment1);
	}

	@Override
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId) {
		List<Payment> list = repository.findByCustId(customerId);
		return PaymentUtils.convertToPaymentDtoList(list);
	}

	@Override
	public List<PaymentDTO> viewPayment(LocalDate startDate, LocalDate endDate) {
		LocalDateTime startDateTime = startDate.atTime(0, 0, 0);
		LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
		List<Payment> payment = repository.findByPaymentDates(startDateTime, endDateTime);
		return PaymentUtils.convertToPaymentDtoList(payment);
	}

	@Override
	public Double calculateTotalCost(Payment payment) {
		return payment.getTotalCost();
	
	}

}
