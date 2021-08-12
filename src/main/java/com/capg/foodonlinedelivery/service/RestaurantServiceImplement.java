package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.RestaurantUtils;
@Service
public class RestaurantServiceImplement implements IRestaurantService {
	@Autowired
	IRestaurantRepository repository;
	@Autowired
	IItemRepository repository2;
	Logger logger=LoggerFactory.getLogger(RestaurantServiceImplement.class);
	@Override
	public RestaurantDTO addRestaurant(Restaurant restaurant) {
		logger.info("Inside service add restaurant method");
		Restaurant restaurant1 = repository.save(restaurant);
		RestaurantDTO restaurantDto = RestaurantUtils.convertToRestaurantDto(restaurant1);
		return restaurantDto;
	}

	@Override
	public RestaurantDTO updateRestaurant(Restaurant restaurant) {
		logger.info("Inside service update restaurant method");
		Restaurant restaurant1 = repository.save(restaurant);
		RestaurantDTO restaurantDto = RestaurantUtils.convertToRestaurantDto(restaurant1);
		return restaurantDto;
	}

	
	@Override
	public String removeRestaurantById(Integer restaurantId) {
		logger.info("Inside service remove restaurant by Id method");
		Restaurant restaurant=repository.findById(restaurantId).orElse(null);
        List<Items> list=repository2.findByRestaurantList_RestaurantName(restaurant.getRestaurantName());	
	for(int i = 0;i<list.size();i++)
	{
		repository2.deleteById(list.get(i).getItemId());
	}
	repository.deleteById(restaurantId);
	return "deleted successfully";
}

	@Override
	public List<RestaurantDTO> viewRestaurant() {
		logger.info("Inside service view restaurants method");
		List<Restaurant> restaurant1 = repository.findAll();
		return RestaurantUtils.convertToRestaurantDtoList(restaurant1);
	}

	@Override
	public List<RestaurantDTO> viewRestaurantByItemName(String name) {
		logger.info("Inside service view restaurant by item name method");
		List<Restaurant> restaurant1 = repository.findByItemList_ItemName(name);
		return RestaurantUtils.convertToRestaurantDtoList(restaurant1);
	}

}
