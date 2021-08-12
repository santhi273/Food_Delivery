package com.capg.foodonlinedelivery.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.exceptionhandler.IdNotFoundException;
import com.capg.foodonlinedelivery.exceptionhandler.InvalidNameException;
import com.capg.foodonlinedelivery.exceptionhandler.RemoveFailedException;
import com.capg.foodonlinedelivery.model.ItemsDTO;
import com.capg.foodonlinedelivery.service.IItemService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/items")
public class ItemsController {

	@Autowired
	IItemService itemService;

	Logger logger = LoggerFactory.getLogger(ItemsController.class);

	@PostMapping(value = "/addItems")
	public ItemsDTO addItems(@RequestBody Items items) {
		logger.info("Inside add items method");
		return itemService.addItems(items);
	}

	@PutMapping(value = "/updateItems")
	public ItemsDTO updateItems(@RequestBody Items items) throws IdNotFoundException {
		logger.info("Inside  update method");
		ItemsDTO itemsDto = itemService.viewItemsById(items.getItemId());
		if (itemsDto == null) {
			throw new IdNotFoundException("Unbale to update item due to invalid id");
		} else {
			ItemsDTO tiemsDto=itemService.updateItems(items);
			return itemsDto;
		}
	}

	@GetMapping("/viewItemByItemId/{itemId}")
	public ItemsDTO viewItemsById(@PathVariable Integer itemId) throws IdNotFoundException {
		logger.info("Inside view item id method");
		ItemsDTO itemsDto = itemService.viewItemsById(itemId);
		if (itemsDto == null) {
			throw new IdNotFoundException("Item id not found..");
		} else {
			return itemsDto;
		}
	}

	@DeleteMapping("/deleteItems/{itemId}")
	public ResponseEntity<String> removeItems(@PathVariable Integer itemId) throws RemoveFailedException {
		logger.info("Inside remove items method");
		ItemsDTO item=itemService.viewItemsById(itemId);
		if (item == null) {
			throw new RemoveFailedException("delete items failed");
		}
		itemService.removeItems(itemId);
		return new ResponseEntity<String>("items deleted", HttpStatus.OK);
	}

	@GetMapping("/viewAllItemsByCategory/{name}")
	public List<ItemsDTO> viewAllItemssByCategory(@PathVariable String name) throws IdNotFoundException {
		logger.info("Inside view items category method");
		List<ItemsDTO> itemsDto = itemService.viewAllItemssByCategory(name);
		if(itemsDto.isEmpty()) {
			throw new IdNotFoundException("Item id not found !!!");
		}
			return itemsDto;
		}
	

	@GetMapping("/findItemsByRestaurant/{name}")
	public List<ItemsDTO> findItemssByRestaurant(@PathVariable String name) throws InvalidNameException {
		logger.info("Inside find item restaurant method");
		List<ItemsDTO> itemsDto = itemService.findItemssByRestaurant(name);
		if (itemsDto.isEmpty()) {
			throw new InvalidNameException("item name is not found..");
		} else {
			return itemsDto;
		}
	}
	
	@GetMapping("/findAllItems")
	public List<ItemsDTO> findAllItems(){
		logger.info("Inside find All items");
		List<ItemsDTO> itemsDto=itemService.findAllItems();
		return itemsDto;
		
	}

}
