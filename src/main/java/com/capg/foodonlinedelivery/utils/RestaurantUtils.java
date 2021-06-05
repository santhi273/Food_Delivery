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
	
	public static Restaurant convertToRestaurant(RestaurantDTO restaurantdto) {
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantId(restaurantdto.getRestaurantId());
		restaurant.setRestaurantName(restaurantdto.getRestaurantName());
		restaurant.setManagerName(restaurantdto.getManagerName());
		restaurant.setPhoneNumber(restaurantdto.getPhoneNumber());
		restaurant.setAddress(restaurantdto.getAddress());
		restaurant.setItemList(restaurantdto.getItemList());
		return restaurant;
	}
	
	
		public static RestaurantDTO convertToRestaurantDto(Restaurant restaurant) {
			RestaurantDTO restaurantdto = new RestaurantDTO();
			restaurantdto.setRestaurantId(restaurant.getRestaurantId());
			restaurantdto.setRestaurantName(restaurant.getRestaurantName());
			restaurantdto.setManagerName(restaurant.getManagerName());
			restaurantdto.setPhoneNumber(restaurant.getPhoneNumber());
			restaurantdto.setAddress(restaurant.getAddress());
			restaurantdto.setItemList(restaurant.getItemList());
			return restaurantdto;
		}
		
}
