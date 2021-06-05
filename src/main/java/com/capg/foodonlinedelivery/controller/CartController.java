package com.capg.foodonlinedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.service.ICartService;

@RestController
@RequestMapping("/Food/cart")
public class CartController {
	@Autowired
ICartService service;
	
	@PostMapping("/add")
	
	public FoodCart additemToCart(@RequestBody FoodCart cart,Items item)
	
	{
		return service.additemToCart(cart, item);		
	}
	@PutMapping(value="/addquantity/{cart}/{item}/{quantity}")
	public FoodCart increaseQuantity(FoodCart cart, Items item, int quantity) {
		return service.increaseQuantity(cart, item, quantity);
	}
	@PutMapping(value="/reducequantity/{cart}/{item}/{quantity}")
	public FoodCart reduceQuantity(FoodCart cart, Items item, int quantity) {
		return service.reduceQuantity(cart, item, quantity);
	}
	@DeleteMapping(value="/delete/{cart}")
	public ResponseEntity<String> clearCart(@PathVariable FoodCart cart){
		service.clearCart(cart);
		return new ResponseEntity<String>("Cart Cleared", HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/delete/{cart}/{item}")
	
	public ResponseEntity<String> deleteItem(@PathVariable FoodCart cart ,Items item) {
		
		service.removeItem(cart,item);
		
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
		
	}
	
}
