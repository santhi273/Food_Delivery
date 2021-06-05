package com.capg.foodonlinedelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.RestaurantDTO;
import com.capg.foodonlinedelivery.service.IRestaurantService;
@RestController
@RequestMapping("/api/Restaurant")
public class RestaurantController {
	@Autowired
	IRestaurantService service;

	@PostMapping(value = "/add", consumes = { "application/json" }, produces = { "application/json" })
	public RestaurantDTO addRestaurant(@RequestBody Restaurant restaurant) {

		return service.addRestaurant(restaurant);
	}

	@PutMapping(value = "/update")
	public RestaurantDTO updateRestaurant(@RequestBody Restaurant restaurant) {

		return service.updateRestaurant(restaurant);
	}

	@DeleteMapping(value = "/delete")
	public String removeRestaurantById(Integer restaurantId) {
		service.removeRestaurantById(restaurantId);
		return "restaurant removed";
	}

	@GetMapping(value = "/get")
	public List<RestaurantDTO> viewRestaurant() {
		return service.viewRestaurant();
	}

	@GetMapping(value = "/get/{Item}/{name}")
	public List<RestaurantDTO> viewRestaurantByItemName(String name) {
		return service.viewRestaurantByItemName(name);
	}

}
