package com.capg.foodonlinedelivery.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.model.PaymentDTO;
import com.capg.foodonlinedelivery.service.IPaymentService;

@RestController
@RequestMapping("/api/Payment")
public class PaymentController {
	@Autowired
	IPaymentService service;

	@PostMapping(value = "/add", consumes = { "application/json" }, produces = { "application/json" })
	public PaymentDTO addPayment(@RequestBody Payment payment) {

		return service.addPayment(payment);
	}

	@PutMapping(value = "/update")
	public PaymentDTO updatePayment(@RequestBody Payment payment) {

		return service.updatePayment(payment);
	}

	@DeleteMapping(value = "/delete")
	public void removePayment(Payment payment) {
		service.removePayment(payment);
	}

	@GetMapping(value = "/Get/{Id}")
	public PaymentDTO viewPaymentById(String paymentId) {
		return service.viewPaymentById(paymentId);
	}

	@GetMapping(value = "/get/{customer}/{Id}")
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId) {
		return service.viewPaymentByCustomerId(customerId);
	}

	@GetMapping(value = "/get/{payment}")
	public List<PaymentDTO> viewPayment(LocalDate startDate, LocalDate endDate) {
		return service.viewPayment(startDate, endDate);
	}

	public PaymentDTO calculateTotalCost(double payment) {
		return service.calculateTotalCost(payment);
	}
}
