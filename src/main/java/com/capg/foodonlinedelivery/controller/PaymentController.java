package com.capg.foodonlinedelivery.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.exceptionhandler.IdNotFoundException;
import com.capg.foodonlinedelivery.model.PaymentDTO;
import com.capg.foodonlinedelivery.service.IPaymentService;

@RestController
@RequestMapping("/api/Payment")
public class PaymentController {
	@Autowired
	IPaymentService service;
	Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping(value = "/add", consumes = { "application/json" }, produces = { "application/json" })
	public PaymentDTO addPayment(@RequestBody OrderDetails order) {
		logger.info("Inside add payment method");
		return service.addPayment(order);
	}

	@PutMapping(value = "/update")
	public PaymentDTO updatePayment(@RequestBody Payment payment) {
		logger.info("Inside update payment method");
		return service.updatePayment(payment);
	}

	@DeleteMapping(value = "/delete")
	public void removePayment(Payment payment) {
		logger.info("Inside remove payment method");
		service.removePayment(payment);
	}

	@GetMapping(value = "/Get/{Id}")
	public PaymentDTO viewPaymentById(Integer paymentId) throws IdNotFoundException{
		logger.info("Inside view payment By Id method");
		PaymentDTO payment=service.viewPaymentById(paymentId);
		if(payment==null)
		{
			throw new IdNotFoundException("Payment Id not found !!!");
		}
		else
		{

		return payment;
		}
	}
	@GetMapping(value = "/get/{customer}/{Id}")
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId) throws IdNotFoundException {
		logger.info("Inside view payment by customer Id method");
		List<PaymentDTO> paymentList = service.viewPaymentByCustomerId(customerId);
		if (paymentList == null) {
			throw new IdNotFoundException("Invalid customer Id !!!");
		} else {

			return service.viewPaymentByCustomerId(customerId);
		}
	}

	@GetMapping(value = "/get/{payment}")
	public List<PaymentDTO> viewPayment(LocalDate startDate, LocalDate endDate) {
		logger.info("Inside view payment by LocalDate method");
		return service.viewPayment(startDate, endDate);
	}

	public Double calculateTotalCost(Payment payment) {
		logger.info("Inside calculate total cost of payment method");
		return service.calculateTotalCost(payment);
	}
}
