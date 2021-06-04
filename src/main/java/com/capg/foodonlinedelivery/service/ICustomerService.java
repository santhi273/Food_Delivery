package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public void deleteCustomer();
	
	public List<Customer> viewAllCustomers();
	
	public Customer ViewCustomer(Customer customer);

}
