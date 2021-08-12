package com.capg.foodonlinedelivery.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.exceptionhandler.IdNotFoundException;
import com.capg.foodonlinedelivery.model.PaymentDTO;
import com.capg.foodonlinedelivery.service.IPaymentService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Payment")
public class PaymentController {
	@Autowired
	IPaymentService service;
	Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping(value = "/add", consumes = { "application/json" }, produces = { "application/json" })
	public PaymentDTO addPayment(@RequestBody Integer orderId) {
		logger.info("Inside add payment method");
		return service.addPayment(orderId);
	}

	@PutMapping(value = "/update")
	public PaymentDTO updatePayment(@RequestBody Payment payment) throws IdNotFoundException{
		logger.info("Inside update payment method");
		PaymentDTO payment1=service.viewPaymentById(payment.getPaymentId());
		if(payment1==null) {
			throw new IdNotFoundException("Payment Id Not found !!!");
		}
		return service.updatePayment(payment);
	}


	@GetMapping(value = "/Get/{paymentId}")
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
	@GetMapping(value = "/get/{customer}/{customerId}")
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId) throws IdNotFoundException {
		logger.info("Inside view payment by customer Id method");
		List<PaymentDTO> paymentList = service.viewPaymentByCustomerId(customerId);
		if (paymentList == null) {
			throw new IdNotFoundException("Invalid customer Id !!!");
		} else {

			return service.viewPaymentByCustomerId(customerId);
		}
	}

	public Double calculateTotalCost(Payment payment){
		logger.info("Inside calculate total cost of payment method");
	
		return service.calculateTotalCost(payment);
	}
}
