package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.foodonlinedelivery.entities.RestaurantLogin;
import com.capg.foodonlinedelivery.repository.IRestaurantLoginRepository;
/**
 * 
 * @author: hemalatha
 * Description:Restaurant login implementation  
 * date: 7/6/2021
 * param:restaurant login entity
 * 
 */
@Service
public class RestaurantLoginServiceImplement implements IRestaurantLoginService  {

	@Autowired
	IRestaurantLoginRepository repository;
	
	Logger logger=LoggerFactory.getLogger(RestaurantLoginServiceImplement.class);

	/**
	 * 
	 * @author: hemalatha
	 * Description:add Restaurant login  
	 * date: 7/6/2021
	 * param:restaurant login entity
	 * return: retaurantLogin
	 */
	@Override
	public RestaurantLogin addRestaurantLogin(RestaurantLogin login) {

		logger.info("Inside service add restaurant login method");
		repository.save(login);
		return login;
	}
	/**
	 * 
	 * @author: hemalatha
	 * Description:delete Restaurant login  
	 * date: 7/6/2021
	 * param:restaurant login entity
	 * return: list<retaurantLogin>
	 */
	
	@Override
	public void deleteRestaurantLogin(int userid) {
		
		logger.info("Inside service delete restaurant login method");
		RestaurantLogin login = repository.findById(userid).orElse(null);
		repository.deleteById(userid);
		//return repository.findAll();
	}
	/**
	 * 
	 * @author: hemalatha
	 * Description:candidate login  
	 * date: 7/6/2021
	 * param:restaurant login entity
	 * return: string
	 */
	
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

	/**
	 * 
	 * @author: hemalatha
	 * Description:update Restaurant login  
	 * date: 7/6/2021
	 * param:restaurant login entity
	 * return: retaurantLogin
	 */
	@Override
	public RestaurantLogin updateRestaurantLogin(RestaurantLogin login) {

		logger.info("Inside service update restaurant login method");
		repository.save(login);
		return login;
	}
	/**
	 * 
	 * @author: hemalatha
	 * Description:candiatelogout  
	 * date: 7/6/2021
	 * param:restaurant login entity
	 * return: string
	 */
	
	@Override
	public String candidateLogout() {
		
		logger.info("Inside service logout restaurant login method");
		String logout = "Logout Successfull ";
		return logout;
	}
}
