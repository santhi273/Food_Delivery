package com.capg.foodonlinedelivery.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.foodonlinedelivery.entities.RestaurantLogin;
import com.capg.foodonlinedelivery.repository.IRestaurantLoginRepository;

@SpringBootTest
public class RestaurantLoginServiceTest {
	@Autowired
	IRestaurantLoginRepository repository;
	@Test
	void testAddRestaurantLogin() {
		RestaurantLogin resl=repository.save(null);
		assertNotNull(resl);
	}
	@Test
	void  testupdateRestaurantLogin(){
		RestaurantLogin resl=repository.save(null);
		assertNotNull(resl);
	}
    @Test
	void testDeleteRestaurantLogin() {
		repository.deleteById(44);
	}


	@Test
	void testCandidateLogin() {
		RestaurantLogin name=repository.findByUserName(null);
		assertNotNull(name);
	}

	@Test
	void testCandidateLogout() {
		String logout="Logout Successfull ";
		assertNotNull(logout);
	}
	public RestaurantLogin restLog()
	{
		RestaurantLogin res=new RestaurantLogin();
		res.setPassword("hema20699");
	    res.setUserid(44);
	    res.setUserName("hema20");
	    return res;
	    
		
	}

}
