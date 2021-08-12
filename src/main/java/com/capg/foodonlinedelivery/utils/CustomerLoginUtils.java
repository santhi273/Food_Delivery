package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;

import com.capg.foodonlinedelivery.entities.CustomerLogin;
import com.capg.foodonlinedelivery.model.CustomerLoginDTO;

public class CustomerLoginUtils {
	public static List<CustomerLoginDTO> convertToCustomerLoginDtoList(List<CustomerLogin> list){
		List<CustomerLoginDTO> dtolist = new ArrayList<CustomerLoginDTO>();
		for(CustomerLogin customerLogin : list) 
			dtolist.add(convertToCustomerLoginDto(customerLogin));
		return dtolist;
	}
	
	public static CustomerLogin convertToCustomerLogin(CustomerLoginDTO customerLogindto) {
		CustomerLogin customerLogin = new CustomerLogin();
		customerLogin.setUserId(customerLogindto.getUserId());
		customerLogin.setUserName(customerLogindto.getUserName());
		customerLogin.setPassword(customerLogindto.getPassword());
		
		return customerLogin;
	}
	
	
	public static CustomerLoginDTO convertToCustomerLoginDto(CustomerLogin customerLogin) {
		CustomerLoginDTO customerLogindto = new CustomerLoginDTO();
		customerLogindto.setUserId(customerLogin.getUserId());
		customerLogindto.setUserName(customerLogin.getUserName());
		customerLogindto.setPassword(customerLogin.getPassword());
		
		return customerLogindto;
		}

	
	

}
