package com.capg.foodonlinedelivery.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
import com.capg.foodonlinedelivery.utils.OrderDetailsUtils;
@Service
@Transactional
public abstract class OrderServiceImplement implements IOrderService {
	@Autowired
	IOrderRepository repo;
	public OrderDetailsDTO addOrder(OrderDetails order) {
	OrderDetails order1 = repo.save(order);
		OrderDetailsDTO orderDetailsDto = OrderDetailsUtils.convertToOrderDetailsDto(order1);
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
		List<OrderDetails> list =repo.findAll();
		List<OrderDetailsDTO> list1=OrderDetailsUtils.convertToOrderDetailsDtoList(list);

		return list1;

	}
}
