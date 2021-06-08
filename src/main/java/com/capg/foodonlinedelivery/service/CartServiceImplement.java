package com.capg.foodonlinedelivery.service;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.FoodCartDTO;
import com.capg.foodonlinedelivery.repository.ICartRepository;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.utils.FoodCartUtils;
@Service
@Transactional
public class CartServiceImplement implements ICartService {
	@Autowired
	ICartRepository cartRepository;
	@Autowired
	IItemRepository itemRepository;
	Logger logger=LoggerFactory.getLogger(CartServiceImplement.class);
	@Override
	public FoodCartDTO additemToCart(FoodCart cart,Items item) {
		logger.info("Inside add item to cart method");
		FoodCart foodCart=new FoodCart();
		if(cart.getItemList().size()==0) {
		cart.getItemList().add(item);
		foodCart=cartRepository.save(cart);
		}
		else {
		int newRestaurantId=item.getRestaurant().getRestaurantId();
		int oldRestaurantId=cart.getItemList().get(0).getRestaurant().getRestaurantId();
		if(newRestaurantId==oldRestaurantId)
		{
			cart.getItemList().add(item);
			foodCart=cartRepository.save(cart);
		}
		}
		return FoodCartUtils.convertToFoodCartDto(foodCart);
		
	}

	@Override
	public FoodCartDTO increaseQuantity(String cartId, String itemId, int quantity) {
		logger.info("Inside icrease quantity method");
		FoodCart cart=cartRepository.getById(cartId);
		int size= cart.getItemList().size();
		int count=0;
		for(int i=0;i<size;i++) {
			String id =cart.getItemList().get(i).getItemId();
			if(itemId==id) {
				count++;
			}
		}
		if(count>0) {
			for(int i=0;i<quantity;i++) {
				additemToCart(cart,itemRepository.getById(itemId));
			}
			FoodCart cart1= cart;
			return FoodCartUtils.convertToFoodCartDto(cart1);
			
		}
		else {
			return null;
		}
	}

	@Override
	public FoodCartDTO reduceQuantity(String cartId, String itemId, int quantity) {
		logger.info("Inside reduce Quantity method");
		FoodCart cart=cartRepository.findById(cartId).orElse(null);	
		Items item=itemRepository.findById(itemId).orElse(null);
		for(int i=0;i<quantity;i++) {
			removeItem(cart,item);
		}
		return FoodCartUtils.convertToFoodCartDto(cart);
		 
	}

	@Override
	public String removeItem(FoodCart cart, Items item) {
		logger.info("Inside remove item method");
		int size= cart.getItemList().size();
		int isPresent=0,index=0;
		for(int i=0;i<size;i++) {
			if(item.getItemId()==cart.getItemList().get(i).getItemId()) {
				isPresent=1;
				index=i;
				break;
			}
		}
		if(isPresent==1) {
			cart.getItemList().remove(index);
		}
		cart.setItemList(cart.getItemList());
		cartRepository.delete(cart);
		return " item removed successfully....";
	}

	@Override
	public String clearCart(FoodCart cart) {
		logger.info("Inside clear method");
			cart.getItemList().clear();
			return "cart cleared";
			
	}

	@Override
	public FoodCart getCartById(String cartId) {
		logger.info("Inside get cart by id method");
		return cartRepository.findById(cartId).orElse(null);
	}
	@Override
	public Items getItemById(String itemId) {
		logger.info("Inside get item by id method");
		return itemRepository.findById(itemId).orElse(null);
	}
}
