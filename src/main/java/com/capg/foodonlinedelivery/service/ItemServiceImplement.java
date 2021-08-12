package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.ItemsDTO;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.utils.ItemsUtils;

@Service
public class ItemServiceImplement implements IItemService {
	@Autowired
	IItemRepository repository;
	Logger logger = LoggerFactory.getLogger(ItemServiceImplement.class);

	@Override
	public ItemsDTO addItems(Items items) {
		logger.info("Inside service add item method");
		Items item1 = repository.save(items);
		return ItemsUtils.convertToItemsDto(item1);

	}

	@Override
	public ItemsDTO updateItems(Items items) {
		logger.info("Inside service update item method");
		Items items1 = repository.save(items);
		return ItemsUtils.convertToItemsDto(items1);

	}

	@Override
	public ItemsDTO viewItemsById(Integer itemId) {
		logger.info("Inside service view item id method");
		Items items1 = repository.findByItemId(itemId);
		return ItemsUtils.convertToItemsDto(items1);

	}

	@Override
	public void removeItems(Items items) {
		logger.info("Inside service delete item method");
		repository.delete(items);

	}

	@Override
	public List<ItemsDTO> viewAllItemssByCategory(String name) {
		logger.info("Inside service view item category method");
		List<Items> list = repository.findItemsByCategory(name);
		return ItemsUtils.convertToItemsDtoList(list);

	}

	@Override
	public List<ItemsDTO> findItemssByRestaurant(String name) {
		logger.info("Inside service find item rstaurent method");
		List<Items> list = repository.findByRestaurantList_RestaurantName(name);
		return ItemsUtils.convertToItemsDtoList(list);

	}
}
