package com.capg.foodonlinedelivery.service;

import java.util.List;
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

	@Override
	public ItemsDTO addItems(Items items) {

		Items item1 = repository.saveAndFlush(items);
		ItemsDTO itemdto = ItemsUtils.convertToItemsDto(items);
		return itemdto;
	}

	@Override
	public ItemsDTO updateItems(Items items) {
		Items items1 = repository.save(items);
		ItemsDTO itemdto = ItemsUtils.convertToItemsDto(items1);
		return itemdto;
	}

	@Override
	public ItemsDTO viewItemsById(Integer id) {
		Items itemId = repository.findById(id).orElse(null);
		ItemsDTO itemdto = ItemsUtils.convertToItemsDto(itemId);
		return itemdto;

	}

	@Override
	public void removeItems(Items items) {
		repository.delete(items);

	}

	@Override
	public List<ItemsDTO> viewAllItemssByCategory(String name) {
		List<Items> list = repository.findItemsByCategory(name);
		List<ItemsDTO> itemdto = ItemsUtils.convertToItemsDtoList(list);
		return itemdto;
	}

	@Override
	public List<ItemsDTO> findItemssByRestaurant(String name) {
		List<Items> list = repository.findItemsByRestaurant(name);
		List<ItemsDTO> itemdto = ItemsUtils.convertToItemsDtoList(list);
		return itemdto;

	}

	@Override
	public List<ItemsDTO> viewAllItemssByItemsName(String name) {

		List<Items> list = repository.findItemsByRestaurant(name);
		List<ItemsDTO> itemdto = ItemsUtils.convertToItemsDtoList(list);
		return itemdto;

	}

}
