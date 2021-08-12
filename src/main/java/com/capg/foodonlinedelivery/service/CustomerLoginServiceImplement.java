package com.capg.foodonlinedelivery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.CustomerLogin;
import com.capg.foodonlinedelivery.exceptionhandler.RemoveFailedException;
import com.capg.foodonlinedelivery.model.CustomerLoginDTO;
import com.capg.foodonlinedelivery.repository.ICustomerLoginRepository;
import com.capg.foodonlinedelivery.utils.CustomerLoginUtils;

@Service
public class CustomerLoginServiceImplement implements ICustomerLoginService {
	
	@Autowired
	ICustomerLoginRepository repository;
	
	Logger logger = LoggerFactory.getLogger(CustomerLoginServiceImplement.class);
	
	@Override
	public CustomerLoginDTO addCustomerLogin(CustomerLogin login) {
		
		logger.info("Inside service add cutomer login method");
		CustomerLogin customerLogin=repository.save(login);
		return CustomerLoginUtils.convertToCustomerLoginDto(customerLogin);
	}
	@Override
	public String deleteCustomerLogin(int userid) {
		
		logger.info("Inside service delete cutomer login method");
		repository.deleteById(userid);
		return "Customer deleted successfully...";
	}
	
	@Override
	public CustomerLoginDTO updateCustomerLogin(CustomerLogin login) {
		
		logger.info("Inside  service update cutomer login method");
		CustomerLogin customerLogin=repository.save(login);
		return CustomerLoginUtils.convertToCustomerLoginDto(customerLogin);	
	}
	
	@Override
	public String customerLogin(String userName, String password) {
		
		logger.info("Inside service login cutomer login method");
		CustomerLogin customer = repository.findByUserName(userName);
		if(customer == null)
		{
			return "Invalid username...";
		}
		else
		{
			
			String usr = customer.getUserName();
			String pwd = customer.getPassword();
			
			if(userName.equals(usr) && password.equals(pwd))
			{
				return "Customer Login successful...";
			}
			else
			{
				return "Invalid password...";
			}

		}
	}	
	

	@Override
	public String customerLogout() {
		
		logger.info("Inside service logout cutomer login method");
		 
		 return "Logout Successfull";
		
	}




	



	
}
