package com.capg.foodonlinedelivery.service;

import java.util.List;


import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.model.CustomerDTO;

public interface ICustomerService {
	
	public CustomerDTO addCustomer(Customer customer);
	
	public CustomerDTO updateCustomer(Customer customer);
	
	public String deleteCustomerById(Integer customerId);
	
	public List<CustomerDTO> viewAllCustomers();

	/**
	 * 
	 * @author: mithila
	 * Description: view customer 
	 * date: 7/6/2021
	 * param:customer  entity
	 * return:customerDto 
	 */
	CustomerDTO viewCustomerById(Integer customerId);

	/**
	 * 
	 * @author: mithila
	 * Description: delete customer 
	 * date: 7/6/2021
	 * param:customer  entity,
	 * return:string 
	 */
	
}
