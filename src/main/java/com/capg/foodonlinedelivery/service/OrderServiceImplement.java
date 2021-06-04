package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.foodonlinedelivery.entities.OrderDetails;
@Service
@Transactional
public class OrderServiceImplement implements IOrderService {

	@Override
	public OrderDetails addOrder(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeOrderById(OrderDetails order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails viewOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrdersByCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrdersByRestaurant(String resName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
