package com.capg.foodonlinedelivery.service;

import java.util.List;

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

	@Override
	public CustomerDTO addCustomer(Customer customer) {
		
		Customer customer1 = repo.save(customer);
		FoodCart cart = new FoodCart();
		cart.setCustomer(customer1);
		repo1.save(cart);
        
		return CustomerUtils.convertToCustomerDto(customer1);
		
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) {

		Customer customer1 = repo.save(customer);
		return CustomerUtils.convertToCustomerDto(customer1);
		 
	}

	@Override
	public void deleteCustomerById(int customerId) {
		
		String cartId = repo1.findCartByCustomerId(customerId);
		repo1.deleteById(cartId);
		repo.deleteById(customerId);
	}

	@Override
	public List<CustomerDTO> viewAllCustomers() {

		List<Customer> list = repo.findAll();
		return CustomerUtils.convertToCustomerDtoList(list);
		 
	}

	@Override
	public CustomerDTO viewCustomerById(int customerId) {
		
		Customer customer = repo.findById(customerId);
		return CustomerUtils.convertToCustomerDto(customer);
		
	}


}
