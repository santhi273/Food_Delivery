package com.capg.foodonlinedelivery.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import javax.persistence.criteria.Order;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;

public interface IOrderService {
public Order addOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public String removeOrderById(OrderDetails order);
	
	public OrderDetailsDTO viewOrderById(int id);
	
	public OrderDetailsDTO viewAllOrdersByCustomer(int id);
	
	public List<OrderDetailsDTO> viewAllOrdersByRestaurant(String resName);

	void removeOrderById(int id);

	OrderDetailsDTO updateOrder(OrderDetails order);

}


