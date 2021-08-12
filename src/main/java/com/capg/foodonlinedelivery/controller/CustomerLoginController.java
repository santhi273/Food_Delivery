package com.capg.foodonlinedelivery.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.capg.foodonlinedelivery.entities.CustomerLogin;
import com.capg.foodonlinedelivery.model.CustomerLoginDTO;
import com.capg.foodonlinedelivery.service.ICustomerLoginService;

@RestController
@RequestMapping("/api/customerLogin")
public class CustomerLoginController {
	
	@Autowired
	ICustomerLoginService service;
	
	Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);
	
	@PostMapping("/addCustomerLogin")
	public ResponseEntity<CustomerLoginDTO> addCustomerLogin(@Valid @RequestBody CustomerLogin login) {
			
		logger.info("Inside add cutomer login method");
		CustomerLoginDTO loginData = service.addCustomerLogin(login);
		return new ResponseEntity<CustomerLoginDTO>(loginData, HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomerLogin")
	public ResponseEntity<CustomerLoginDTO> updateCustomerLogin(@Valid @RequestBody CustomerLogin login) {
		
		logger.info("Inside update cutomer login method");
		CustomerLoginDTO loginData = service.updateCustomerLogin(login);
		return new ResponseEntity<CustomerLoginDTO>(loginData, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomerLogin/{userId}")
	public ResponseEntity<String> deleteCustomerLogin(@PathVariable("userId") int userid) {
		
		logger.info("Inside delete cutomer login method");
		String msg =  service.deleteCustomerLogin(userid);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/customerLogin/{username}/{password}")
	public ResponseEntity<String> customerLogin(@PathVariable String username,@PathVariable String password) 
	{
		logger.info("Inside login cutomer login method");
		String login=service.customerLogin(username,password);
		return new ResponseEntity<String>(login, HttpStatus.OK);
	}
	
	@GetMapping("/customerLogout")
	public ResponseEntity<String> candidateLogout() 
	{
		logger.info("Inside logout cutomer login method");
		String logout=service.customerLogout();
		return new ResponseEntity<String>(logout, HttpStatus.OK);
	}


	

}
