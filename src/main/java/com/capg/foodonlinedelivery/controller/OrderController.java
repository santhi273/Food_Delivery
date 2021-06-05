package com.capg.foodonlinedelivery.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Category;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.service.IOrderService;

@RestController
@RequestMapping("/api/Order")
public class OrderController {
	
	@Autowired
	IOrderService service;
	
	@PostMapping(value = "/add", consumes = {"application/json"}, produces = {"application/json"})
	public Order addOrder(Order order) {
		
		return service.addOrder(order);
	}
	
	@PutMapping(value = "/update")
	public Order updateOrder(Order order) {
		
		return service.updateOrder(order);
	}
	
	@GetMapping(value = "/get/{Id}")
	public OrderDetails viewOrderById(int CustomerId) {
		
		return service.viewOrderById(CustomerId);
	}
	
	@DeleteMapping(value = "/delete/{Id}")
	public void  removeOrderById(int OrderId) {
		
		 service.removeOrderById(OrderId);
		 
	}	 
	
	@GetMapping(value = "/get/restaurantName")
	public List<OrderDetails> viewAllOrdersByRestaurant(String restaurantName) {
		
		return service.viewAllOrdersByRestaurant(restaurantName);
	}
	@GetMapping(value = "/get/{Id}")
	public Optional<OrderDetails> viewAllOrdersByCustomer(int CustomerId) {
		
		return service.viewAllOrdersByCustomer(CustomerId);
	}
	

}
