package com.capg.foodonlinedelivery.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import javax.persistence.criteria.Order;
import com.capg.foodonlinedelivery.entities.OrderDetails;

public interface IOrderService {
public Order addOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public String removeOrderById(OrderDetails order);
	
	public OrderDetails viewOrderById(int id);
	
	public Optional<OrderDetails> viewAllOrdersByCustomer(int id);
	
	public List<OrderDetails> viewAllOrdersByRestaurant(String resName);

	void removeOrderById(int id);

	OrderDetails updateOrder(OrderDetails order);

}


