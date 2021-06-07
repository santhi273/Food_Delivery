package com.capg.foodonlinedelivery.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import com.capg.foodonlinedelivery.utils.OrderDetailsUtils;
@Service
@Transactional
public abstract class OrderServiceImplement implements IOrderService {
	@Autowired
	IOrderRepository repo;
	
	
	@Autowired
	ICartRepository repo2;
	
	@Autowired
	IItemRepository repo3;	
	
	@Autowired
	CartServiceImplement service;
	/*public OrderDetailsDTO addOrder(OrderDetails order) {
	OrderDetails order1 = repo.save(order);
		OrderDetailsDTO orderDetailsDto = OrderDetailsUtils.convertToOrderDetailsDto(order1);
		return orderDetailsDto;
	}*/
	public OrderDetailsDTO addOrder(FoodCart cartId) {
		
		//logger.info("Inside service add order method");
		OrderDetails order = new OrderDetails();
		//OrderDetailsDTO orderDetailsDto = OrderDetailsUtils.convertToOrderDetailsDto(order1);
		//return orderDetailsDto;
		//OrderDetailsDTO order=new OrderDetailsDTO();
		FoodCart cart=repo2.findById(cartId).orElse(null);
		List<Items> orderList=new ArrayList<Items>();
		
		List<Items> item1=cart.getItemList();
		int list_size=item1.size();
		for(int i=0;i<list_size;i++)
		{
			Items item=item1.get(i);
			orderList.add(item);
		}
		Restaurant rest=item1.get(0).getRestaurant();
		order.setCustomer(cart.getCustomer());
		order.setRestaurant(rest);
		order.setList(orderList);
		order.setOrderDate(LocalDateTime.now());
		order.setOrderStatus("Pending");
		repo.save(order);
		service.clearCart(cartId);	
		OrderDetailsDTO orderDetailsDto = OrderDetailsUtils.convertToOrderDetailsDto(order);
		return orderDetailsDto;
	}



	@Override
	public OrderDetailsDTO updateOrder(OrderDetails order) {
		OrderDetails order1 = repo.save(order);
		OrderDetailsDTO orderDetailsDto = OrderDetailsUtils.convertToOrderDetailsDto(order1);
		return orderDetailsDto;
	}

	
	@Override
	public void  removeOrderById(int OrderId) {
		repo.deleteById(OrderId);
	}

	@Override
	public OrderDetailsDTO viewOrderById(int CustomerId) {
		OrderDetails order1 = repo.findById(CustomerId).orElse(new OrderDetails());
		OrderDetailsDTO orderDetailsDto = OrderDetailsUtils.convertToOrderDetailsDto(order1);
		return orderDetailsDto;
	
		
	}

	@Override
	public OrderDetailsDTO viewAllOrdersByCustomer(int CustomerId) {
	
		OrderDetails order1 = repo.findById(CustomerId).orElse(new OrderDetails());
		OrderDetailsDTO orderDetailsDto = OrderDetailsUtils.convertToOrderDetailsDto(order1);
		return orderDetailsDto;
	
	}

	@Override
	public List<OrderDetailsDTO> viewAllOrdersByRestaurant(String restaurantName) {
		List<OrderDetails> list =repo.findAllByRestaurant(restaurantName);
		List<OrderDetailsDTO> list1=OrderDetailsUtils.convertToOrderDetailsDtoList(list);
		System.out.println(list);
		return list1;

	}
}
