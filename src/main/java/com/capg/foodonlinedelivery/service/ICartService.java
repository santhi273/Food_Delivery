package com.capg.foodonlinedelivery.service;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;

import com.capg.foodonlinedelivery.model.FoodCartDTO;
public interface ICartService {
	public FoodCartDTO additemToCart(FoodCart cart,Items item);
	public FoodCartDTO increaseQuantity(String cartId,String itemId,int quantity);
	public FoodCartDTO reduceQuantity(String cartId,String itemId,int quantity);
	public String removeItem(FoodCart cart, Items item);
	public  String clearCart(FoodCart cart);
	FoodCart getCartById(String cartId);
	Items getItemById(String itemId);
}
