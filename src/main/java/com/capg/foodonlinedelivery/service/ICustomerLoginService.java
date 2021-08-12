package com.capg.foodonlinedelivery.service;

import com.capg.foodonlinedelivery.entities.CustomerLogin;
import com.capg.foodonlinedelivery.model.CustomerLoginDTO;

public interface ICustomerLoginService {
	
	public CustomerLoginDTO addCustomerLogin(CustomerLogin customerLogin);
	
	public CustomerLoginDTO updateCustomerLogin(CustomerLogin customerLogin);
	
	public String deleteCustomerLogin(int userid);
	
	public String customerLogin(String userName,String password);
	
	public String customerLogout();

	


}
