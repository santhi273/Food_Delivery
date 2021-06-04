package com.capg.foodonlinedelivery.service;

import java.util.List;


import com.capg.foodonlinedelivery.entities.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public void deleteCustomerById(int customerId);
	
	public List<Customer> viewAllCustomers();

	public Customer viewCustomerById(int customerId);
	
}
