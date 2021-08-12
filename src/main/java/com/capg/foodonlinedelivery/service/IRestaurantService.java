package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;

public interface IRestaurantService {
	public RestaurantDTO addRestaurant(Restaurant restaurant);
	public RestaurantDTO updateRestaurant(Restaurant restaurant);
	public List<RestaurantDTO> viewRestaurantByItemName(String name);
	public List<RestaurantDTO> viewRestaurant();
	public String removeRestaurantById(Integer restaurantId);
	public RestaurantDTO viewRestaurantById(Integer restaurantId);


}
