package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.RestaurantUtils;

public class RestaurantServiceImplement implements IRestaurantService {
	@Autowired
	IRestaurantRepository repository;
	@Autowired
	IItemRepository repository2;

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
	public String removeRestaurantById(Integer restaurantId) {
		Restaurant restaurant=repository.findById(restaurantId).orElse(null);
        List<Items> list=repository2.findItemsByRestaurant(restaurant.getRestaurantName());	
	for(int i = 0;i<list.size();i++)
	{
		repository2.deleteById(list.get(i).getItemId());
	}
	repository.deleteById(restaurantId);
	return "deleted successfully";
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
