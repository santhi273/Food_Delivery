package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.foodonlinedelivery.entities.OrderDetails;
@Service
@Transactional
public abstract class OrderServiceImplement implements IOrderService {

	public abstract OrderDetails addOrder(int cartId);
	{

	}
		public abstract OrderDetails updateOrder(OrderDetails order);
		{
		}
		
		
		public abstract String removeOrderById(OrderDetails order);
		{
		}
		
		public abstract OrderDetails viewOrderById(int id);{
		}
		public abstract List<OrderDetails> viewAllOrdersByCustomer(int id);
		{
		}
		public abstract List<OrderDetails> viewAllOrdersByRestaurant(String resName);
		{
		
	}

}
