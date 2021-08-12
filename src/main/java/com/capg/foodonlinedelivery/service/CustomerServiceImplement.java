package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.model.CustomerDTO;
import com.capg.foodonlinedelivery.repository.ICartRepository;
import com.capg.foodonlinedelivery.repository.ICustomerRepository;
import com.capg.foodonlinedelivery.utils.CustomerUtils;

@Service
public class CustomerServiceImplement implements ICustomerService {
	
	@Autowired
	ICustomerRepository repo;
	@Autowired
	ICartRepository repo1;
	Logger logger=LoggerFactory.getLogger(CustomerServiceImplement.class);

	@Override
	public CustomerDTO addCustomer(Customer customer) {
		
		logger.info("Inside service add customer method");
		Customer customer1 = repo.save(customer);
		FoodCart cart = new FoodCart();
		cart.setCustomer(customer1);
		repo1.save(cart);
        
		return CustomerUtils.convertToCustomerDto(customer1);
		
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) {
        
		logger.info("Inside service update customer method");
		Customer customer1 = repo.save(customer);
		return CustomerUtils.convertToCustomerDto(customer1);
		 
	}

	@Override
	public String deleteCustomerById(int customerId) {
		
		logger.info("Inside service delete customer method");
		FoodCart cart = repo1.findCartByCustomerId(customerId);
		repo1.delete(cart);
		repo.deleteById(customerId);
		return "Customer Deleted Successfully";
	}

	@Override
	public List<CustomerDTO> viewAllCustomers() {
        
		logger.info("Inside service view all customers");
		List<Customer> list = repo.findAll();
		return CustomerUtils.convertToCustomerDtoList(list);
		 
	}

	@Override
	public CustomerDTO viewCustomerById(int customerId) {
		
		logger.info("Inside service view customer by Id method");
		Customer customer = repo.findById(customerId);
		return CustomerUtils.convertToCustomerDto(customer);
		
	}


}
