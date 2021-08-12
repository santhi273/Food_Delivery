package com.capg.foodonlinedelivery.service;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.model.FoodCartDTO;
import com.capg.foodonlinedelivery.repository.ICartRepository;
import com.capg.foodonlinedelivery.repository.ICustomerRepository;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.FoodCartUtils;
/**
 * 
 * @author: santhi
 * Description:cart service implementation
 * date: 7/6/2021
 *
 */
@Service
public class CartServiceImplement implements ICartService {
	@Autowired
	ICartRepository cartRepository;
	@Autowired
	ICustomerRepository customerRepository;
	@Autowired
	IItemRepository itemRepository;
	@Autowired
	IRestaurantRepository resRepository;
	@Autowired
	IRestaurantService service;
	Logger logger=LoggerFactory.getLogger(CartServiceImplement.class);
	/**
	 * 
	 * @author: santhi
	 * Description:add items to cart service
	 * date: 7/6/2021
	 * param:cart, item entity
	 *return : foodCartDto
	 */
	@Override
	public FoodCartDTO additemToCart(int cartId,int customerId,Items item) {
		logger.info("Inside add item to cart method");
		item=itemRepository.findById(item.getItemId()).orElse(null);
		FoodCart cart=null;
		if(cartId==0) {
			cart=new FoodCart();
			cart.setItemList(new ArrayList<Items>());
			Customer customer=customerRepository.getById(customerId);
			cart.setCustomer(customer);
			
		}
		
		else {
		cart=cartRepository.getById(cartId);
		}
		FoodCart foodCart=null;
			cart.getItemList().add(item);
			 foodCart=cartRepository.save(cart);
		
		return FoodCartUtils.convertToFoodCartDto(foodCart);
		
	
	}
	/**
	 * 
	 * @author: santhi
	 * Description:increase quantity
	 * date: 7/6/2021
	 * param:cart, item entity,
	 *return : foodCartDto
	 */
	@Override
	public FoodCartDTO increaseQuantity(Integer cartId, Integer itemId, int quantity) {
		logger.info("Inside icrease quantity method");
		FoodCart cart=cartRepository.findById(cartId).orElse(null);
		Items item=itemRepository.findByItemId(itemId);
		int quantity1=item.getQuantity();
		item.setQuantity(quantity1+quantity);
		itemRepository.save(item);
		
			return FoodCartUtils.convertToFoodCartDto(cart);
	}
	/**
	 * 
	 * @author: santhi
	 * Description:reduce quantity
	 * date: 7/6/2021
	 * param:cart, item entity,
	 *return : foodCartDto
	 */
	@Override
	public FoodCartDTO reduceQuantity(Integer cartId, Integer itemId, int quantity) {
		logger.info("Inside reduce Quantity method");
		FoodCart cart=cartRepository.findById(cartId).orElse(null);	
		Items item=itemRepository.findByItemId(itemId);
		if(cart==null||item==null) {
			return null;
		}else {
		int quantity1=item.getQuantity();
		if(quantity>=quantity1) {
		
			removeItem(cart,item);
		}
		else {
			item.setQuantity(quantity1-quantity);
			itemRepository.save(item);
					}
		return FoodCartUtils.convertToFoodCartDto(cart);
		}
	}
	/**
	 * 
	 * @author: santhi
	 * Description:remove item
	 * date: 7/6/2021
	 * param:cart, item entity
	 *return : foodCartDto
	 */
	@Override
	public String removeItem(FoodCart cart, Items item) {
		logger.info("Inside remove item method");
	
		int size= cart.getItemList().size();
		int isPresent=0,index=0;
		for(int i=0;i<size;i++) {
			if(item.getItemId()==cart.getItemList().get(i).getItemId()) {
				isPresent=1;
				index=i;
				break;
			}
		}
		if(isPresent==1) {
			cart.getItemList().remove(index);
		
		}
		cart.setItemList(cart.getItemList());
		cartRepository.save(cart);
		return " item removed successfully....";
	}
	
	
	/**
	 * 
	 * @author: santhi
	 * Description:clear cart
	 * date: 7/6/2021
	 * param:cart, item entity,
	 *return : string
	 */
	@Override
	public String clearCart(int cartId) {
		logger.info("Inside clear method");
		FoodCart cart=cartRepository.findById(cartId).orElse(null);
			cart.getItemList().clear();
			return "cart cleared";
				}
	
	/**
	 * 
	 * @author: santhi
	 * Description:view cart
	 * date: 7/6/2021
	 * param:cart, item entity,
	 *return : foodCart
	 */
	@Override
	public FoodCart getCartById(Integer cartId) {
		logger.info("Inside get cart by id method");
		return cartRepository.findById(cartId).orElse(null);
	}
	/**
	 * 
	 * @author: santhi
	 * Description:view cart 
	 * date: 7/6/2021
	 * param:cart, item entity,
	 *return : foodCart
	 */
	@Override
	public Items getItemById(Integer itemId) {
		logger.info("Inside get item by id method");
		return itemRepository.findByItemId(itemId);
	}
}
