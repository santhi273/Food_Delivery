package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.ItemsDTO;

public interface IItemService {
	public ItemsDTO addItems(Items items);

	public ItemsDTO updateItems(Items items);

	public ItemsDTO viewItemsById(String itemId);

	public void removeItems(Items items);

	public List<ItemsDTO> viewAllItemssByCategory(String name);

	public List<ItemsDTO> findItemssByRestaurant(String name);

}
