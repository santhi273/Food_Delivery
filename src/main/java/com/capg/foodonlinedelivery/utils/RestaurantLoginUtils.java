package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;

import com.capg.foodonlinedelivery.entities.RestaurantLogin;
import com.capg.foodonlinedelivery.model.RestaurantLoginDTO;

public class RestaurantLoginUtils {
	public static List<RestaurantLoginDTO> convertToRestaurantLoginDtoList(List<RestaurantLogin> list){
		List<RestaurantLoginDTO> dtolist = new ArrayList<RestaurantLoginDTO>();
		for(RestaurantLogin RestaurantLogin : list) 
			dtolist.add(convertToRestaurantLoginDto(RestaurantLogin));
		return dtolist;
	}
	
	public static RestaurantLogin convertToRestaurantLogin(RestaurantLoginDTO restaurantLogindto) {
		RestaurantLogin restaurantLogin = new RestaurantLogin();
		restaurantLogin.setUserid(restaurantLogindto.getUserid());
		restaurantLogin.setUserName(restaurantLogindto.getUserName());
		restaurantLogin.setPassword(restaurantLogindto.getPassword());
		
		return restaurantLogin;
	}
	
	
		public static RestaurantLoginDTO convertToRestaurantLoginDto(RestaurantLogin restaurantLogin) {
			RestaurantLoginDTO RestaurantLogindto = new RestaurantLoginDTO();
			RestaurantLogindto.setUserid(restaurantLogin.getUserid());
			RestaurantLogindto.setUserName(restaurantLogin.getUserName());
			RestaurantLogindto.setPassword(restaurantLogin.getPassword());
			return RestaurantLogindto;
		}
		
}


