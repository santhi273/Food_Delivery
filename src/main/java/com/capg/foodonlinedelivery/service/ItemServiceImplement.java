package com.capg.foodonlinedelivery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.repository.IItemRepository;

@Service
public class ItemServiceImplement implements IItemService {
	@Autowired
	IItemRepository repository;

	@Override
	public Items addItems(Items items) {

<<<<<<< HEAD
		Items item1 = repository.saveAndFlush(items);
		ItemsDTO itemdto = ItemsUtils.convertToItemsDto(item1);
		return itemdto;
=======
		return repository.saveAndFlush(items);
>>>>>>> branch 'master' of https://github.com/santhi273/Food_Delivery
	}

	@Override
	public Items updateItems(Items items) {
		return repository.save(items);
	}

	@Override
	public Items viewItemsById(Integer id) {
		return repository.findById(id).orElse(null);

	}

	@Override
	public String removeItems(Items items) {
		repository.delete(items);
		return "iteams deleted";
	}

	@Override
	public List<Items> viewAllItemssByCategory(String name) {
		List<Items> list = repository.findItemsByCategory(name);
		return list;
	}

	@Override
	public List<Items> findItemssByRestaurant(String name) {
		List<Items> list = repository.findItemsByRestaurant(name);
		return list;

	}

	@Override
	public List<Items> viewAllItemssByItemsName(String name) {

		List<Items> list = repository.findItemsByRestaurant(name);
		return list;

	}

}
