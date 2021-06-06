package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.ItemsDTO;

@Component
public class ItemsUtils {
	public static List<ItemsDTO> convertToItemsDtoList(List<Items> list) {
		List<ItemsDTO> dtolist = new ArrayList<ItemsDTO>();
		for (Items items : list)
			dtolist.add(convertToItemsDto(items));
		return dtolist;
	}

	public static Items convertToItems(ItemsDTO itemsdto) {
		Items items = new Items();
		items.setItemId(itemsdto.getItemId());
		items.setItemName(itemsdto.getItemName());
		items.setCategory(itemsdto.getCategory());
		items.setQuantity(itemsdto.getQuantity());
		items.setCost(itemsdto.getCost());
		items.setRestaurant(itemsdto.getRestaurant());
		return items;
	}

	public static ItemsDTO convertToItemsDto(Items items) {
		ItemsDTO itemsdto = new ItemsDTO();
		itemsdto.setItemId(items.getItemId());
		itemsdto.setItemName(items.getItemName());
		itemsdto.setCategory(items.getCategory());
		itemsdto.setQuantity(items.getQuantity());
		itemsdto.setCost(items.getCost());
		itemsdto.setRestaurant(items.getRestaurant());
		itemsdto.setRestaurantList(items.getRestaurantList());
		return itemsdto;
	}
}
