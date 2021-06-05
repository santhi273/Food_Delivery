package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.model.CustomerDTO;
import com.capg.foodonlinedelivery.repository.ICustomerRepository;
import com.capg.foodonlinedelivery.utils.CustomerUtils;

@Service
public class CustomerServiceImplement implements ICustomerService {
	
	@Autowired
	ICustomerRepository repo;

	@Override
	public CustomerDTO addCustomer(Customer customer) {

		Customer customer1 = repo.save(customer);
		CustomerDTO customerDto = CustomerUtils.convertToCustomerDto(customer1);
		return customerDto;
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) {

		Customer customer1 = repo.save(customer);
		CustomerDTO customerDto = CustomerUtils.convertToCustomerDto(customer1);
		return customerDto;
	}

	@Override
	public void deleteCustomerById(int customerId) {

		repo.deleteById(customerId);
	}

	@Override
	public List<CustomerDTO> viewAllCustomers() {

		List<Customer> list = repo.findAll();
		List<CustomerDTO> listdto = CustomerUtils.convertToCustomerDtoList(list);
		return listdto;
	}

	@Override
	public CustomerDTO viewCustomerById(int customerId) {
		
		Customer customer = repo.findById(customerId);
		CustomerDTO customerDto = CustomerUtils.convertToCustomerDto(customer);
		return customerDto;
	}


}
