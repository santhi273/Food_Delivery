package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;

import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;



public class RestaurantUtils {
	public static List<RestaurantDTO> convertToRestaurantDtoList(List<Restaurant> list){
		List<RestaurantDTO> dtolist = new ArrayList<RestaurantDTO>();
		for(Restaurant Restaurant : list) 
			dtolist.add(convertToRestaurantDto(Restaurant));
		return dtolist;
	}
	
	public static Restaurant convertToRestaurant(RestaurantDTO Restaurantdto) {
		Restaurant Restaurant = new Restaurant();
		Restaurant.setSalary(Restaurantdto.getSalary());
		Restaurant.setName(Restaurantdto.getName());
		Restaurant.setId(Restaurantdto.getId());
		return Restaurant;
	}
	
	
		public static RestaurantDTO convertToRestaurantDto(Restaurant Restaurant) {
			RestaurantDTO Restaurantdto = new RestaurantDTO();
			Restaurantdto.setSalary(Restaurant.getSalary());
			Restaurantdto.setName(Restaurant.getName());
			Restaurantdto.setId(Restaurant.getId());
			return Restaurantdto;
		}
		
}
