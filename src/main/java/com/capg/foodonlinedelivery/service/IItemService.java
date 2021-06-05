package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Items;

public interface IItemService {
	public Items addItems(Items items);

	public Items updateItems(Items items);

	public Items viewItemsById(Integer id);

	public String removeItems(Items items);

	public List<Items> viewAllItemssByCategory(String name);

	public List<Items> findItemssByRestaurant(String name);

	public List<Items> viewAllItemssByItemsName(String name);

}
