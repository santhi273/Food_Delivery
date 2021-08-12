package com.capg.foodonlinedelivery.service;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;

import com.capg.foodonlinedelivery.model.FoodCartDTO;
public interface ICartService {
	public FoodCartDTO additemToCart(int cartId,int customerId,Items item);
	public FoodCartDTO increaseQuantity(Integer cartId,Integer itemId,int quantity);
	public FoodCartDTO reduceQuantity(Integer cartId,Integer itemId,int quantity);
	public String removeItem(FoodCart cart, Items item);
	public  String clearCart(int cartId);
	FoodCart getCartById(Integer cartId);
	Items getItemById(Integer itemId);
	
}
