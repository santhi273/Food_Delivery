package com.capg.foodonlinedelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.ItemsDTO;
import com.capg.foodonlinedelivery.service.IItemService;

@RestController
@RequestMapping("/api/items")
public class ItemsController {

	@Autowired
	IItemService itemservice;

	@PostMapping(value = "/addItems")
	public ItemsDTO addItems(@RequestBody Items items) {
		return itemservice.addItems(items);
	}

	@PutMapping(value = "/updateItems")
	public ItemsDTO updateItems(@RequestBody Items items) {
		return itemservice.updateItems(items);
	}

	@GetMapping("/viewItemByItemId/{itemId}")
	public ItemsDTO viewItemsById(@PathVariable String itemId) {
		return itemservice.viewItemsById(itemId);
	}

	@DeleteMapping("/deleteItems/{items}")
	public void removeItems(@PathVariable Items items) {
		itemservice.removeItems(items);
	}

	@GetMapping("/viewAllItemsByCategory/{categoryName}")
	public List<ItemsDTO> viewAllItemssByCategory(@PathVariable String name) {
		return itemservice.viewAllItemssByCategory(name);
	}

	@GetMapping("/findItemsByRestaurant/{restaurantName}")
	public List<ItemsDTO> findItemssByRestaurant(@PathVariable String name) {
		return itemservice.findItemssByRestaurant(name);
	}

}
