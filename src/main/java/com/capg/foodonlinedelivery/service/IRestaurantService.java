package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;

public interface IRestaurantService {
	public RestaurantDTO addRestaurant(Restaurant restaurant);
	public RestaurantDTO updateRestaurant(Restaurant restaurant);
	public void removeRestaurant(Restaurant restaurant);
	public List<RestaurantDTO> viewRestaurantByItemName(String name);
	public List<RestaurantDTO> viewRestaurant();


}
