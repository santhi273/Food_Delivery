package com.capg.foodonlinedelivery.service;

import javax.transaction.Transactional;

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
	ICartRepository repo;
	@Autowired
	IItemRepository repo1;
	@Override
	public FoodCartDTO additemToCart(FoodCart cart,Items item) {
		FoodCart foodCart=new FoodCart();
		if(cart.getItemList().size()==0) {
		cart.getItemList().add(item);
		foodCart=repo.save(cart);
		}
		else {
		int newRestaurantId=item.getRestaurant().getRestaurantId();
		int oldRestaurantId=cart.getItemList().get(0).getRestaurant().getRestaurantId();
		if(newRestaurantId==oldRestaurantId)
		{
			cart.getItemList().add(item);
			foodCart=repo.save(cart);
		}
		}
		return FoodCartUtils.convertToFoodCartDto(foodCart);
		
	}

	@Override
	public FoodCartDTO increaseQuantity(FoodCart cart, Items item, int quantity) {
		int size= cart.getItemList().size();
		int count=0;
		for(int i=0;i<size;i++) {
			String id =cart.getItemList().get(i).getItemId();
			if(item.getItemId()==id) {
				count++;
			}
		}
		if(count>0) {
			for(int i=0;i<quantity;i++) {
				additemToCart(cart,item);
			}
			FoodCart cart1= cart;
			return FoodCartUtils.convertToFoodCartDto(cart1);
			
		}
		else {
			return null;
		}
	}

	@Override
	public FoodCartDTO reduceQuantity(FoodCart cart, Items item, int quantity) {
		for(int i=0;i<quantity;i++) {
			removeItem(cart,item);
		}
		FoodCart cart1= cart;
		return FoodCartUtils.convertToFoodCartDto(cart1);
		 
	}

	@Override
	public String removeItem(FoodCart cart, Items item) {
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
		repo.save(cart);
		return " item removed successfully....";
	}

	@Override
	public String clearCart(FoodCart cart) {
			cart.getItemList().clear();
			return "cart cleared";
			
	}
	public FoodCart getCartById(String cartId) {
		return repo.findById(cartId).orElse(null);
	}
	@Override
	public Items getItemById(int itemId) {
		return repo1.findById(itemId).orElse(null);
	}
}
