package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.RestaurantUtils;

public class RestaurantServiceImplement implements IRestaurantService {
	@Autowired
	IRestaurantRepository repository;

	@Override
	public RestaurantDTO addRestaurant(Restaurant restaurant) {
		Restaurant restaurant1 = repository.save(restaurant);
		RestaurantDTO restaurantDto = RestaurantUtils.convertToRestaurantDto(restaurant1);
		return restaurantDto;
	}

	@Override
	public RestaurantDTO updateRestaurant(Restaurant restaurant) {
		Restaurant restaurant1 = repository.save(restaurant);
		RestaurantDTO restaurantDto = RestaurantUtils.convertToRestaurantDto(restaurant1);
		return restaurantDto;
	}

	@Override
	public void removeRestaurant(Restaurant restaurant) {
     repository.delete(restaurant);
	}

	@Override
	public List<RestaurantDTO> viewRestaurant() {
		List<Restaurant> restaurant1 = repository.findAll();
		return RestaurantUtils.convertToRestaurantDtoList(restaurant1);
	}

	@Override
	public List<RestaurantDTO> viewRestaurantByItemName(String name) {
		List<Restaurant> restaurant1 = repository.findByItemName(name);
		return RestaurantUtils.convertToRestaurantDtoList(restaurant1);
	}

}
