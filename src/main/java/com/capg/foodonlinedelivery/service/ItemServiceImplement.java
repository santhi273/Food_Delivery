package com.capg.foodonlinedelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.ItemsDTO;
import com.capg.foodonlinedelivery.repository.ICartRepository;
import com.capg.foodonlinedelivery.repository.ICategoryRepository;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.ItemsUtils;
/**
 * 
 * @author: venkatesh
 * Description:item service implementation 
 * date: 7/6/2021
 * param:item  entity
 * 
 */
@Service
public class ItemServiceImplement implements IItemService {
	@Autowired
	IItemRepository repository;
	@Autowired
	ICartRepository cartRepository;
	@Autowired
	ICategoryRepository categoryRepository;
	@Autowired
	IRestaurantRepository restaurantRepository;
	@Autowired
	ICartService cartService;
	@Autowired
	IOrderRepository orderRepository;
	@Autowired
	IRestaurantService restaurantService;
	Logger logger = LoggerFactory.getLogger(ItemServiceImplement.class);
	/**
	 * 
	 * @author: venkatesh
	 * Description:add item  
	 * date: 7/6/2021
	 * param:item  entity
	 * return : itemDto
	 * 
	 */
	@Override
	public ItemsDTO addItems(Items items) {
		logger.info("Inside service add item method");
		Items item1 = repository.save(items);
		return ItemsUtils.convertToItemsDto(item1);

	}
	/**
	 * 
	 * @author: venkatesh
	 * Description:updata item  
	 * date: 7/6/2021
	 * param:item  entity
	 * return : itemDto
	 * 
	 */
	@Override
	public ItemsDTO updateItems(Items items) {
		logger.info("Inside service update item method");
		Items items1 = repository.save(items);
		return ItemsUtils.convertToItemsDto(items1);

	}
	/**
	 * 
	 * @author: venkatesh
	 * Description:view item  
	 * date: 7/6/2021
	 * param:item  entity
	 * return : itemDto
	 * 
	 */
	@Override
	public ItemsDTO viewItemsById(Integer itemId) {
		logger.info("Inside service view item id method");
		Items items1 = repository.findById(itemId).orElse(null);
		if(items1==null) {
			return null;
		}
		return ItemsUtils.convertToItemsDto(items1);

	}
	/**
	 * 
	 * @author: venkatesh
	 * Description:remove item  
	 * date: 7/6/2021
	 * param:item  entity
	 * return : void
	 * 
	 */
	
	@Override
	public void removeItems(Integer itemId) {
		logger.info("Inside service delete item method");
	
		Items item=repository.getById(itemId);
		
		for(int i=0;i<item.getCart().size();i++) {
			FoodCart cart=cartRepository.getById(item.getCart().get(i).getCartId());
			cartService.removeItem(cart, item);
		}
		for(int i=0;i<item.getRestaurantList().size();i++) {
			Restaurant restaurant=restaurantRepository.getById(item.getRestaurantList().get(i).getRestaurantId());
			restaurant.setItemList(restaurant.getItemList().stream().filter(it->it.getItemId()!=item.getItemId()).collect(Collectors.toList()));
			
		}
		List<OrderDetails> order=orderRepository.findByList_ItemId(itemId);
		for(int i=0;i<order.size();i++) {
			OrderDetails order1=orderRepository.getById(order.get(i).getOrderId());
			order1.setList(order1.getList().stream().filter(it->it.getItemId()!=item.getItemId()).collect(Collectors.toList()));
		}
		item.setCategory(null);
		item.setRestaurantList(null);
		item.setCart(null);
		repository.save(item);
		
		repository.delete(item);
		

	}
	/**
	 * 
	 * @author: venkatesh
	 * Description:view item  
	 * date: 7/6/2021
	 * param:item  entity
	 * return :list< itemDto>
	 * 
	 */
	@Override
	public List<ItemsDTO> viewAllItemssByCategory(String name) {
		logger.info("Inside service view item category method");
		List<Items> list = repository.findByCategory_CategoryName(name);
		return ItemsUtils.convertToItemsDtoList(list);

	}
	/**
	 * 
	 * @author: venkatesh
	 * Description:view item  
	 * date: 7/6/2021
	 * param:item  entity
	 * return :list< itemDto>
	 * 
	 */
	@Override
	public List<ItemsDTO> findItemssByRestaurant(String name) {
		logger.info("Inside service find item rstaurent method");
		List<Items> list = repository.findByRestaurantList_RestaurantName(name);
		return ItemsUtils.convertToItemsDtoList(list);

	}
	@Override
	public List<ItemsDTO> findAllItems(){
		logger.info("Inside service find all items");
		List<Items> list=repository.findAll();
		return ItemsUtils.convertToItemsDtoList(list);
	}
}
