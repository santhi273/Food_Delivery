package com.capg.foodonlinedelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.RestaurantUtils;
/**
 * 
 * @author: hemalatha
 * Description:Restaurant service Implementation
 * date: 7/6/2021
 * param:restaurant entity
 * 
 */
@Service
public class RestaurantServiceImplement implements IRestaurantService {
	@Autowired
	IRestaurantRepository repository;
	@Autowired
	IItemRepository repository2;
	@Autowired
	IOrderRepository orderRepository;
	Logger logger=LoggerFactory.getLogger(RestaurantServiceImplement.class);
	/**
	 * 
	 * @author: hemalatha
	 * Description:add Restaurant 
	 * date: 7/6/2021
	 * param:restaurant entity
	 * return: restaurant Dto
	 */
	@Override
	public RestaurantDTO addRestaurant(Restaurant restaurant) {
		logger.info("Inside service add restaurant method");
		Restaurant restaurant1 = repository.save(restaurant);
		RestaurantDTO restaurantDto = RestaurantUtils.convertToRestaurantDto(restaurant1);
		return restaurantDto;
	}
	/**
	 * 
	 * @author: hemalatha
	 * Description:update Restaurant 
	 * date: 7/6/2021
	 * param:restaurant entity
	 * return: restaurant Dto
	 */
	@Override
	public RestaurantDTO updateRestaurant(Restaurant restaurant) {
		logger.info("Inside service update restaurant method");
		Restaurant restaurant1 = repository.save(restaurant);
		RestaurantDTO restaurantDto = RestaurantUtils.convertToRestaurantDto(restaurant1);
		return restaurantDto;
	}

	/**
	 * 
	 * @author: hemalatha
	 * Description:remove Restaurant 
	 * date: 7/6/2021
	 * param:restaurant entity
	 * return:string
	 */
	
	@Override
	public String removeRestaurantById(Integer restaurantId) {
		logger.info("Inside service remove restaurant by Id method");
		Restaurant restaurant=repository.getById(restaurantId);
		List<Items> item=restaurant.getItemList();
		for(int i=0;i<item.size();i++) {
			Items item1=repository2.getById(restaurant.getItemList().get(i).getItemId());
			item1.setRestaurantList(item.get(i).getRestaurantList().stream().filter(it->it.getRestaurantId()!=restaurant.getRestaurantId()).collect(Collectors.toList()));
		}
		repository.save(restaurant);
		repository.deleteById(restaurantId);
	return "deleted successfully";
}
	/**
	 * 
	 * @author: hemalatha
	 * Description:view Restaurant 
	 * date: 7/6/2021
	 *
	 * return: list<restaurant Dto>
	 */
	@Override
	public List<RestaurantDTO> viewRestaurant() {
		logger.info("Inside service view restaurants method");
		List<Restaurant> restaurant1 = repository.findAll();
		return RestaurantUtils.convertToRestaurantDtoList(restaurant1);
	}
	/**
	 * 
	 * @author: hemalatha
	 * Description:view Restaurant 
	 * date: 7/6/2021
	 *
	 * return: list<restaurant Dto>
	 */
	@Override
	public List<RestaurantDTO> viewRestaurantByItemName(String name) {
		logger.info("Inside service view restaurant by item name method");
		List<Restaurant> restaurant1 = repository.findByItemList_ItemName(name);
		if(restaurant1.isEmpty()) {
			return null;
		}
		else {
		return RestaurantUtils.convertToRestaurantDtoList(restaurant1);
		}
	}
	@Override
	public RestaurantDTO viewRestaurantById(Integer restaurantId) {
		logger.info("Inside service view restaurant by id");
		Restaurant restaurant=repository.findById(restaurantId).orElse(null);
		if(restaurant==null) {
			return null;
		}
		else {
		return RestaurantUtils.convertToRestaurantDto(restaurant);
	}
	}

}
