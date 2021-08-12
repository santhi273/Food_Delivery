package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.CustomerLogin;
import com.capg.foodonlinedelivery.repository.ICustomerLoginRepository;

@SpringBootTest
class ICustomerLoginServiceTest {
	
	@Autowired
	ICustomerLoginRepository repository;
	
	@Test
	void testAddCustomerLogin() {
		
		CustomerLogin login=repository.save(getLogin());
		assertNotNull(login);
	}

	@Test
	void testUpdateCustomerLogin() {
		
		CustomerLogin login=repository.save(getLogin());
		assertNotNull(login);
	}

	@Test
	void testCustomerLogin() {
		System.out.println("testCustomerLogin");
		CustomerLogin login=repository.findByUserName("Aniket");
		System.out.println(login);
		assertNotNull(login);
	}
	@Test
	void testDeleteCustomerLogin() {
		
		repository.deleteById(57);
		CustomerLogin login=repository.getById(57);
		System.out.println(login);
		assertNull(login);
	}


	public CustomerLogin getLogin()
	{
		CustomerLogin login=new CustomerLogin();
		login.setUserId(57);
		login.setUserName("Aniket");
		login.setPassword("A0017");
		return login;
	}


}
