package com.capg.foodonlinedelivery.service;

import java.util.List;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.ItemsDTO;

public interface IItemService {
	public ItemsDTO addItems(Items items);

	public ItemsDTO updateItems(Items items);

	public ItemsDTO viewItemsById(Integer itemId);


	public List<ItemsDTO> viewAllItemssByCategory(String name);

	public List<ItemsDTO> findItemssByRestaurant(String name);

	/**
	 * 
	 * @author: venkatesh
	 * Description:remove item  
	 * date: 7/6/2021
	 * param:item  entity
	 * return : void
	 * 
	 */
	void removeItems(Integer itemId);

	public List<ItemsDTO> findAllItems();

}
