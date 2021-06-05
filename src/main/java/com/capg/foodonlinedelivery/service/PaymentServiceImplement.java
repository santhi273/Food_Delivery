package com.capg.foodonlinedelivery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.model.PaymentDTO;
import com.capg.foodonlinedelivery.repository.IPaymentRepository;
import com.capg.foodonlinedelivery.utils.PaymentUtils;
@Service
public class PaymentServiceImplement implements IPaymentService {
     @Autowired
     IPaymentRepository repo;
	@Override
	public PaymentDTO addPayment(Payment payment) {
       Payment payment1=repo.save(payment);
        PaymentDTO paymentDto=PaymentUtils.convertToPaymentDto(payment1);
		return paymentDto;
	}

	@Override
	public PaymentDTO updatePayment(Payment payment) {
        Payment payment1=repo.save(payment);
        PaymentDTO paymentDto=PaymentUtils.convertToPaymentDto(payment1);
		return paymentDto;	
		}

	@Override
	public void  removePayment(Payment payment) {
		repo.delete(payment);
	}

	@Override
	public PaymentDTO viewPaymentById(String paymentId) {
        Payment payment1=repo.findById(paymentId).orElse(null);
        PaymentDTO paymentDto=PaymentUtils.convertToPaymentDto(payment1);
		return paymentDto;	
			}

	@Override
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId) {
	List<Payment> list=repo.findByCustId(customerId);
	return PaymentUtils.convertToPaymentDtoList(list);
	}

	@Override
	public List<PaymentDTO> viewPayment(LocalDate startDate, LocalDate endDate) {
		LocalDateTime startDateTime = startDate.atTime(0,0, 0);
        LocalDateTime endDateTime = endDate.atTime(23,59,59);
        List<Payment> payment=repo.findByPaymentDates(startDateTime, endDateTime);
        return PaymentUtils.convertToPaymentDtoList(payment);
	}

	@Override
	public PaymentDTO calculateTotalCost(double payment) {
		return null;
	}
	


}
