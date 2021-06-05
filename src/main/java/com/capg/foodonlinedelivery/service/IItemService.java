package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.ItemsDTO;

public interface IItemService {
	public ItemsDTO addItems(Items items);

	public Items updateItems(Items items);

	public Items viewItemsById(Integer id);

	public String removeItems(Items items);

	public List<Items> viewAllItemssByCategory(String name);

	public List<Items> findItemssByRestaurant(String name);

	public List<Items> viewAllItemssByItemsName(String name);

}
