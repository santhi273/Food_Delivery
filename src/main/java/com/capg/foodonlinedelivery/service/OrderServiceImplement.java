package com.capg.foodonlinedelivery.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;
import com.capg.foodonlinedelivery.repository.ICartRepository;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.OrderDetailsUtils;
@Service
@Transactional
public class OrderServiceImplement implements IOrderService {
	@Autowired
	IOrderRepository repo;
	
	
	@Autowired
	ICartRepository repo2;
	
	@Autowired
	IItemRepository repo3;	
	@Autowired
	IRestaurantRepository repo4;
	@Autowired
	CartServiceImplement service;
	Logger logger=LoggerFactory.getLogger(OrderServiceImplement.class);

@Override
	public OrderDetailsDTO addOrder(OrderDetails order) {
	logger.info("Inside service add order method");
	OrderDetails order1=new OrderDetails();
		FoodCart cart=repo2.findCartByCustomerId(order1.getCustomer().getCustomerId());
		List<Items> orderList=new ArrayList<Items>();
		
		List<Items> item1=cart.getItemList();
		int list_size=item1.size();
		for(int i=0;i<list_size;i++)
		{
			Items item=item1.get(i);
			orderList.add(item);
		}
		int rest=item1.get(0).getRestaurantList().get(0).getRestaurantId();
		Restaurant restaurant=repo4.getById(rest);
		order1.setCustomer(cart.getCustomer());
		order1.setRestaurant(restaurant);
		order1.setList(orderList);
		order1.setOrderDate(LocalDateTime.now());
		order1.setOrderStatus("Pending");
		repo.save(order1);
		service.clearCart(cart);	
		 return OrderDetailsUtils.convertToOrderDetailsDto(order1);
		
	}




	@Override
	public OrderDetailsDTO updateOrder(OrderDetails order) {
		logger.info("Inside service update order method");
		OrderDetails order1 = repo.save(order);
		return OrderDetailsUtils.convertToOrderDetailsDto(order1);
		
	}

	
	@Override
	public String  removeOrderById(int OrderId) {
        logger.info("Inside service remove order method");

		repo.deleteById(OrderId);
		return "Order removed successfully...";
	}


	

	@Override
	public OrderDetailsDTO viewOrderById(int orderId) {
		logger.info("Inside service view order by Id method");
		OrderDetails order1 = repo.findById(orderId);
		return OrderDetailsUtils.convertToOrderDetailsDto(order1);
		
	
		
	}

	@Override
	public List<OrderDetailsDTO> viewAllOrdersByCustomer(int customerId) {
		logger.info("Inside service view all order by customer Id method");

		List<OrderDetails> order1 = repo.findAllOrdersByCustomer(customerId);
	     return OrderDetailsUtils.convertToOrderDetailsDtoList(order1);
	
	
	}

	@Override
	public List<OrderDetailsDTO> viewAllOrdersByRestaurant(String restaurantName) {
		logger.info("Inside service view all order by restaurant name method");

		List<OrderDetails> list =repo.findAllByRestaurant(restaurantName);
		return OrderDetailsUtils.convertToOrderDetailsDtoList(list);
		

	}
	
}
