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
		return ItemsUtils.convertToItemsDto(item1);

	}

	@Override
	public ItemsDTO updateItems(Items items) {
		Items items1 = repository.save(items);
		return ItemsUtils.convertToItemsDto(items1);

	}

	@Override
	public ItemsDTO viewItemsById(Integer id) {
		Items items1 = repository.findById(id).orElse(null);
		return ItemsUtils.convertToItemsDto(items1);

	}

	@Override
	public void removeItems(Items items) {
		repository.delete(items);

	}
	@Override
	public List<ItemsDTO> viewAllItemsByCategory(String name) {
		List<Items> list = repository.findItemsByCategory(name);
		return ItemsUtils.convertToItemsDtoList(list);

	}

	@Override
	public List<ItemsDTO> findItemsByRestaurant(String name) {
		List<Items> list = repository.findItemsByRestaurant(name);
		return ItemsUtils.convertToItemsDtoList(list);

	}

	@Override
	public List<ItemsDTO> viewAllItemsByItemsName(String name) {

		List<Items> list = repository.findItemsByRestaurant(name);
		return ItemsUtils.convertToItemsDtoList(list);

	}

}
