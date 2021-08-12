package com.capg.foodonlinedelivery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.exceptionhandler.DistinctRestaurantException;
import com.capg.foodonlinedelivery.exceptionhandler.RemoveFailedException;
import com.capg.foodonlinedelivery.model.FoodCartDTO;
import com.capg.foodonlinedelivery.service.ICartService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/food/cart")
public class CartController {
	@Autowired
	ICartService service;
	Logger logger=LoggerFactory.getLogger(CartController.class);
	@PostMapping("/{cartId}/add")
	public FoodCartDTO additemToCart(@PathVariable int cartId,@RequestParam(required=true) int customerId, Items item) throws DistinctRestaurantException {
		FoodCartDTO cart1=service.additemToCart(cartId,customerId, item);
		
		if(cart1==null) {
			logger.error("Exception");
			throw new DistinctRestaurantException("You cannot add items from different restuarant.");
		}
		
		return cart1;
	}

	@PutMapping(value = "/addquantity/{cartId}/{itemId}/{quantity}")
	public FoodCartDTO increaseQuantity(@PathVariable Integer cartId,@PathVariable Integer itemId,@PathVariable int quantity) {
		
		return service.increaseQuantity(cartId, itemId, quantity);
	}

	@PutMapping(value = "/reducequantity/{cartId}/{itemId}/{quantity}")
	public FoodCartDTO reduceQuantity(@PathVariable Integer cartId,@PathVariable Integer itemId,@PathVariable int quantity) throws RemoveFailedException {
		FoodCartDTO cart=service.reduceQuantity(cartId, itemId, quantity);
		if(cart==null) {
			logger.error("Exception");
			throw new RemoveFailedException("Item Id is not present in cart !");
		}
		return cart;
	}

	@DeleteMapping(value = "/clear/{cartId}")
	public ResponseEntity<String> clearCart(@PathVariable int cartId) {
		service.clearCart(cartId);
		return new ResponseEntity<String>("Cart Cleared", HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{cart}/{item}")

	public ResponseEntity<String> deleteItem(@PathVariable FoodCart cart,@PathVariable Items item) throws RemoveFailedException {
		if(cart==null||item==null) {
			logger.error("Exception");
			throw new RemoveFailedException("Item Id is not present in cart !");
		}
		service.removeItem(cart, item);

		return new ResponseEntity<String>("item removed", HttpStatus.OK);

	}

}
