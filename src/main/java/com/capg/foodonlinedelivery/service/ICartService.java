package com.capg.foodonlinedelivery.service;


import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;

public interface ICartService {
public FoodCart additemToCart(FoodCart cart,Items item);
public FoodCart increaseQuantity(FoodCart cart,Items item,int quantity);
public FoodCart reduceQuantity(FoodCart cart,Items item,int quantity);
public String removeItem(FoodCart cart, Items item);
public  String clearCart(FoodCart cart);
}
