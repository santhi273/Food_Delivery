package com.capg.foodonlinedelivery.service;

import java.util.List;


import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.model.CustomerDTO;

public interface ICustomerService {
	
	public CustomerDTO addCustomer(Customer customer);
	
	public CustomerDTO updateCustomer(Customer customer);
	
	public void deleteCustomerById(int customerId);
	
	public List<CustomerDTO> viewAllCustomers();

	public CustomerDTO viewCustomerById(int customerId);
	
}
