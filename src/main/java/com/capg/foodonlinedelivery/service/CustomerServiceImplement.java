package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.repository.ICustomerRepository;

@Service
public class CustomerServiceImplement implements ICustomerService {
	
	@Autowired
	ICustomerRepository repo;

	@Override
	public Customer addCustomer(Customer customer) {

		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return repo.save(customer);
	}

	@Override
	public void deleteCustomerById(int customerId) {

		repo.deleteById(customerId);
	}

	@Override
	public List<Customer> viewAllCustomers() {

		return repo.findAll();
	}

	@Override
	public Customer viewCustomerById(int customerId) {
		
		return repo.findById(customerId);
	}


}
