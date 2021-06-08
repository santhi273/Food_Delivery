package com.capg.foodonlinedelivery.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.model.CustomerDTO;
import com.capg.foodonlinedelivery.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	ICustomerService service;

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping(value = "/add", consumes = { "application/json" }, produces = { "application/json" })
	public CustomerDTO addCustomer(@Valid @RequestBody Customer customer) {

		logger.info("Inside add customer method");
		CustomerDTO customer1 = service.addCustomer(customer);
		return customer1;

	}

	@PutMapping(value = "/update")
	public CustomerDTO updateCustomer(@Valid @RequestBody Customer customer) throws IdNotFoundException {

		logger.info("Inside update customer method");
		CustomerDTO customer1 = service.viewCustomerById(customer.getCustomerId());
		if (customer1 == null) {
			throw new IdNotFoundException("Customer id not found to update !!!");
		} else {
			CustomerDTO customer2 = service.updateCustomer(customer);
			return customer2;
		}
	}

	@GetMapping(value = "/get")
	public List<CustomerDTO> viewAllCustomers() throws invalidNameException {
		logger.info("Inside view customer by restaurant name method");
		List<CustomerDTO> customer = service.viewAllCustomers();
		if (customer.isEmpty()) {
			throw new invalidNameException("Invalid restaurant name !!!");
		}
		return customer;
	}

	@DeleteMapping(value = "/delete/{Id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int customerId) throws removeFailedException {
		logger.info("Inside delete customer method");
		CustomerDTO customer1 = service.viewCustomerById(customerId);
		if (customer1 == null) {
			throw new removeFailedException("Delete customer operation failed !!!");
		} else {

			String result = service.deleteCustomerById(customerId);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}

	}

	@GetMapping(value = "/get/{Id}")
	public CustomerDTO viewCustomerById(@PathVariable int customerId) throws IdNotFoundException {

		logger.info("Inside view customer by Id method");
		CustomerDTO customer = service.viewCustomerById(customerId);
		if (customer == null) {
			throw new IdNotFoundException("Customer Id not found !!!");
		}
		return customer;
	}

}
