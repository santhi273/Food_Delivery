package com.capg.foodonlinedelivery.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
@Service
@Transactional
public abstract class OrderServiceImplement implements IOrderService {
	@Autowired
	IOrderRepository repo;
	public OrderDetails addOrder(OrderDetails order) {
	
		return repo.save(order);
	}


	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		return repo.save(order);
	}

	
	@Override
	public void  removeOrderById(int OrderId) {
		// TODO Auto-generated method stub
		repo.deleteById(OrderId);
	}

	@Override
	public OrderDetails viewOrderById(int CustomerId) {
		// TODO Auto-generated method stub
		return repo.findById(CustomerId).orElse(new OrderDetails());
	}

	@Override
	public Optional<OrderDetails> viewAllOrdersByCustomer(int CustomerId) {
		// TODO Auto-generated method stub
		return  repo.findById(CustomerId);
	}

	@Override
	public List<OrderDetails> viewAllOrdersByRestaurant(String restaurantName) {
		// TODO Auto-generated method stub
		return  repo.findByName(restaurantName);

	}


	

}
