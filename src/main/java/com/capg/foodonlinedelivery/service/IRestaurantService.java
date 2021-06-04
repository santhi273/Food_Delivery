package com.capg.foodonlinedelivery.service;

import com.capg.foodonlinedelivery.entities.Restaurant;

public interface IRestaurantService {
	public Restaurant addRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res);
	public Restaurant removeRestaurant(Restaurant res);
	public Restaurant viewRestaurant(Restaurant res);
	public Restaurant viewRestaurantByItemName(String name);


}
