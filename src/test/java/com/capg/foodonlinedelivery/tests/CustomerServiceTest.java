package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.Address;
import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.repository.ICustomerRepository;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	ICustomerRepository repository;
	
	@Test
	void testAddCustomer() {
		
		Customer customer=repository.save(getCustomer());
		assertNotNull(customer);
	}

	@Test
	void testUpdateCustomer() {
		
		Customer customer=repository.save(getCustomer());
		assertNotNull(customer);
	}

	@Test
	void testViewCustomerById() {

		Optional<Customer> customer=repository.findById(1);
		assertNotNull(customer);
	}

	@Test
	void testViewAllCustomer() {
		
		List<Customer> list=repository.findAll();
		int cnt=list.size();
		boolean res=false;
		if(cnt>0)
		{
			res=true;
		}
		assertTrue(res);
	}
	
	public Customer getCustomer()
	{
		Customer customer=new Customer();
		customer.setAddress(getAddress());
		customer.setCustomerId(10);
		customer.setEmailId("Amit@gmail.com");
		customer.setFirstName("Amit");
		customer.setGender("M");
		customer.setLastName("Shinde");
		customer.setPhoneNumber("9876543218");
		return customer;
	}
	
	
	public Address getAddress()
	{
		Address address=new Address();
		address.setAddressId(12);
		address.setdNo(123);
		address.setArea("Hadapsar");
		address.setCity("Pune");
		address.setState("AndhraPradesh");
		address.setPinCode(511511);
		address.setCountry("India");
		return address;
	}


}
