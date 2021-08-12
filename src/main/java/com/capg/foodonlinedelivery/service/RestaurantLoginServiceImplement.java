package com.capg.foodonlinedelivery.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.foodonlinedelivery.entities.RestaurantLogin;
import com.capg.foodonlinedelivery.repository.IRestaurantLoginRepository;
@Service
public class RestaurantLoginServiceImplement implements IRestaurantLoginService  {

	@Autowired
	IRestaurantLoginRepository repository;
	
	Logger logger=LoggerFactory.getLogger(RestaurantLoginServiceImplement.class);

	
	@Override
	public RestaurantLogin addRestaurantLogin(RestaurantLogin login) {

		logger.info("Inside service add restaurant login method");
		repository.save(login);
		return login;
	}

	
	@Override
	public List<RestaurantLogin> deleteRestaurantLogin(int userid) {
		
		logger.info("Inside service delete restaurant login method");
		RestaurantLogin login = repository.findById(userid).orElse(null);
		repository.deleteById(userid);
		return repository.findAll();
	}

	
	@Override
	public String candidateLogin(String username, String password) {
		
		logger.info("Inside service login restaurant login method");
		RestaurantLogin rest=repository.findByUserName(username);
		if(rest==null)
		{
			return "Invalid username...";
		}
		else
		{
			
			String usr=rest.getUserName();
			String pwd=rest.getPassword();
			
			if(username.equals(usr) && password.equals(pwd))
			{
				return "Login successful...";
			}
			else
			{
				return "Invalid password...";
			}
		}
	}

	
	@Override
	public RestaurantLogin updateRestaurantLogin(RestaurantLogin login) {

		logger.info("Inside service update restaurant login method");
		repository.save(login);
		return login;
	}

	
	@Override
	public String candidateLogout() {
		
		logger.info("Inside service logout restaurant login method");
		String logout = "Logout Successfull ";
		return logout;
	}
}
