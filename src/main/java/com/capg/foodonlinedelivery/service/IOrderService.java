package com.capg.foodonlinedelivery.service;

import java.util.List;

import javax.persistence.criteria.Order;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;

public interface IOrderService {

public OrderDetailsDTO viewOrderById(Integer id);

public List<OrderDetailsDTO> viewAllOrdersByCustomer(Integer id);

public List<OrderDetailsDTO> viewAllOrdersByRestaurant(Integer id);

public String removeOrderById(Integer id);

public OrderDetailsDTO updateOrder(OrderDetails order);

public OrderDetailsDTO addOrder(OrderDetails order);

}


