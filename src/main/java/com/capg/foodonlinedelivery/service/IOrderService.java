package com.capg.foodonlinedelivery.service;

import java.util.List;

import javax.persistence.criteria.Order;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;

public interface IOrderService {

public OrderDetailsDTO viewOrderById(int id);

public List<OrderDetailsDTO> viewAllOrdersByCustomer(int id);

public List<OrderDetailsDTO> viewAllOrdersByRestaurant(String resName);

public String removeOrderById(int id);

public OrderDetailsDTO updateOrder(OrderDetails order);

public OrderDetailsDTO addOrder(OrderDetails order);

}


