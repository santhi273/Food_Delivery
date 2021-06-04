package com.capg.foodonlinedelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	
	@PostMapping(value = "/add", consumes = {"application/json"}, produces = {"application/json"})
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return service.addCustomer(customer);
	}
	
	@PutMapping(value = "/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		return service.updateCustomer(customer);
	}
	
	@GetMapping(value = "/get")
	public List<Customer> viewAllCustomers(){
		
		return service.viewAllCustomers();
	}
	
	@DeleteMapping(value = "/delete/{Id}")
	public void deleteCustomerById(@PathVariable int customerId) {
		
		service.deleteCustomerById(customerId);
	}
	
	@GetMapping(value = "/get/{Id}")
	public Customer viewCustomerById(int customerId) {
		
		return service.viewCustomerById(customerId);
	}
	

}
