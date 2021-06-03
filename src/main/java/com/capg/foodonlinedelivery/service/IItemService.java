package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

public interface IItemService {
	public Item addItem(Item item);

	public Item updateItem(Item item);

	public Item viewItemById(Integer id);

	public Item removeItem(Item item);

	public List<Item> viewAllItemsByCategory(String name);

	public List<Item> findItemsByRestaurant(String name);

	public List<Item> viewAllItemsByItemName(String name);


}
