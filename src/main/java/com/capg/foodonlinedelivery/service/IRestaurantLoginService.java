package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.RestaurantLogin;

public interface IRestaurantLoginService {
	
	public RestaurantLogin addRestaurantLogin(RestaurantLogin login);
	
	public RestaurantLogin updateRestaurantLogin(RestaurantLogin login);
	
	public  List <RestaurantLogin> deleteRestaurantLogin(int userid);
	
	public String candidateLogin(String username,String password);
	
	public String candidateLogout();
	
}


