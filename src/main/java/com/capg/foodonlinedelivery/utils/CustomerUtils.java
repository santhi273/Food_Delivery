package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.model.CustomerDTO;

public class CustomerUtils {
	
	public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> list){
		List<CustomerDTO> dtolist = new ArrayList<CustomerDTO>();
		for(Customer Customer : list) 
			dtolist.add(convertToCustomerDto(Customer));
		return dtolist;
	}
	
	public static Customer convertToCustomer(CustomerDTO customerdto) {
		Customer customer = new Customer();
		customer.setCustomerId(customerdto.getCustomerId());
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setEmailId(customerdto.getEmailId());
		customer.setAddress(customerdto.getAddress());
		customer.setPhoneNumber(customerdto.getPhoneNumber());
		customer.setGender(customerdto.getGender());
		return customer;
	}
	
	
	public static CustomerDTO convertToCustomerDto(Customer customer) {
		CustomerDTO customerdto = new CustomerDTO();
		customerdto.setCustomerId(customer.getCustomerId());
		customerdto.setFirstName(customer.getFirstName());
		customerdto.setLastName(customer.getLastName());
		customerdto.setEmailId(customer.getEmailId());
		customerdto.setAddress(customer.getAddress());
		customerdto.setPhoneNumber(customer.getPhoneNumber());
		customerdto.setGender(customer.getGender());
		return customerdto;
		}

}
