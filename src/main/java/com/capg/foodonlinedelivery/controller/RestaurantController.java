package com.capg.foodonlinedelivery.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.exceptionhandler.IdNotFoundException;
import com.capg.foodonlinedelivery.exceptionhandler.InvalidItemNameException;
import com.capg.foodonlinedelivery.exceptionhandler.RemoveFailedException;
import com.capg.foodonlinedelivery.model.RestaurantDTO;
import com.capg.foodonlinedelivery.service.IRestaurantService;
import com.capg.foodonlinedelivery.utils.RestaurantUtils;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Restaurant")
public class RestaurantController {
	@Autowired
	IRestaurantService service;
	Logger logger=LoggerFactory.getLogger(RestaurantController.class);
	
	@PostMapping(value = "/add", consumes = { "application/json" }, produces = { "application/json" })
	public RestaurantDTO addRestaurant(@RequestBody Restaurant restaurant) {
		logger.info("Inside add restaurant method");
		return service.addRestaurant(restaurant);
	}

	@PutMapping(value = "/update")
	public RestaurantDTO updateRestaurant(@RequestBody Restaurant restaurant) throws IdNotFoundException{
	
		logger.info("Inside update restaurant method");
		RestaurantDTO restaurant1=service.viewRestaurantById(restaurant.getRestaurantId());
		if(restaurant1==null)
		{
			throw new IdNotFoundException("Restaurant not available to update !!!");
		}
		else
		{	
		return service.updateRestaurant(restaurant);}
	}

	@DeleteMapping(value = "/delete/{restaurantId}")
	public ResponseEntity<String> removeRestaurantById(@PathVariable Integer restaurantId) throws RemoveFailedException{
		
		logger.info("Inside remove restaurant by Id method");
		RestaurantDTO restaurant=service.viewRestaurantById(restaurantId);
		if(restaurant==null)
		{
			throw new RemoveFailedException("Remove restaurant failed !!!");
		}
		else
		{
			String msg = service.removeRestaurantById(restaurantId); 
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/get")
	public List<RestaurantDTO> viewRestaurant() {
		logger.info("Inside view all restaurants method");
		return service.viewRestaurant();
	}

	@GetMapping(value = "/get/{Item}/{name}")
	public List<RestaurantDTO> viewRestaurantByItemName(String name) throws InvalidItemNameException{
		
		logger.info("Inside view restaurant by item name method");
		List<RestaurantDTO> list =  service.viewRestaurantByItemName(name);
		logger.error(name);
		if(list==null)
		{
			throw new InvalidItemNameException("Item not available !!!");
		}
		else
		{
            return service.viewRestaurantByItemName(name);
	}

}
}