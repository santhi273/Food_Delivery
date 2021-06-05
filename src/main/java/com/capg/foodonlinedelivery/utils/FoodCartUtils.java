package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;
import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.model.FoodCartDTO;

public class FoodCartUtils {
	public static List<FoodCartDTO> convertToFoodCartDtoList(List<FoodCart> list){
		List<FoodCartDTO> dtolist = new ArrayList<FoodCartDTO>();
		for(FoodCart FoodCart : list) 
			dtolist.add(convertToFoodCartDto(FoodCart));
		return dtolist;
	}
	
	public static FoodCart convertToFoodCart(FoodCartDTO foodCartdto) {
		FoodCart foodCart = new FoodCart();
		foodCart.setCartId(foodCartdto.getCartId());
		foodCart.setCustomer(foodCartdto.getCustomer());
		foodCart.setItemList(foodCartdto.getItemList());
		return foodCart;
	}
	
	
		public static FoodCartDTO convertToFoodCartDto(FoodCart foodCart) {
			FoodCartDTO foodCartdto = new FoodCartDTO();
			foodCartdto.setCartId(foodCart.getCartId());
			foodCartdto.setCustomer(foodCart.getCustomer());
			foodCartdto.setItemList(foodCart.getItemList());
			
			return foodCartdto;
		}
}
