package com.capg.foodonlinedelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.entities.Restaurant;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;
import com.capg.foodonlinedelivery.repository.ICartRepository;
import com.capg.foodonlinedelivery.repository.ICustomerRepository;
import com.capg.foodonlinedelivery.repository.IItemRepository;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
import com.capg.foodonlinedelivery.repository.IPaymentRepository;
import com.capg.foodonlinedelivery.repository.IRestaurantRepository;
import com.capg.foodonlinedelivery.utils.OrderDetailsUtils;
/**
 * 
 * @author: sumanth
 * Description:order service implement  
 * date: 7/6/2021
 * param:oderdetails  entity
 * 
 * 
 */
@Service
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
	IPaymentRepository repo5;
	@Autowired
	ICustomerRepository repo6;
	@Autowired
	IItemService itemService;
	@Autowired
	IPaymentService paymentService;
	@Autowired
	CartServiceImplement service;
	Logger logger=LoggerFactory.getLogger(OrderServiceImplement.class);
	/**
	 * 
	 * @author: sumanth
	 * Description:add order 
	 * date: 7/6/2021
	 * param:oderdetails  entity
	 * return :orderdetailsdto
	 * 
	 */
	@Override
	public OrderDetailsDTO addOrder(OrderDetails order) {
	logger.info("Inside service add order method");
	
	Customer customer=repo6.getById(order.getCustomer().getCustomerId());
	Restaurant restaurant=repo4.getById(order.getRestaurant().getRestaurantId());
	List<Items> item=repo3.findAllById(order.getList().stream().map(Items::getItemId).collect(Collectors.toList()));
	order.setCustomer(customer);
	order.setList(item);
	order.setRestaurant(restaurant);
		repo.save(order);
		 return OrderDetailsUtils.convertToOrderDetailsDto(order);
		
	}
	/**
	 * 
	 * @author: sumanth
	 * Description:update order 
	 * date: 7/6/2021
	 * param:oderdetails  entity
	 * return :orderdetailsdto
	 * 
	 */
	@Override
	public OrderDetailsDTO updateOrder(OrderDetails order) {
		logger.info("Inside service update order method");
		OrderDetails order1 = repo.save(order);
		return OrderDetailsUtils.convertToOrderDetailsDto(order1);
		
	}
	/**
	 * 
	 * @author: sumanth
	 * Description:remove order 
	 * date: 7/6/2021
	 * param:oderdetails  entity
	 * return :string
	 * 
	 */

	@Override
	public String  removeOrderById(Integer orderId) {
        logger.info("Inside service remove order method");
       OrderDetails order=repo.getById(orderId);
       order.setCustomer(null);
       order.setList(null);
       order.setRestaurant(null);
       repo.save(order);
       Payment payment=repo5.findByorder_OrderId(orderId);

       repo5.deleteById(payment.getPaymentId());
		return "Order removed successfully...";
	}


	/**
	 * 
	 * @author: sumanth
	 * Description:view order 
	 * date: 7/6/2021
	 * param:oderdetails  entity
	 * return :orderdetailsdto
	 * 
	 */

	@Override
	public OrderDetailsDTO viewOrderById(Integer orderId) {
		logger.info("Inside service view order by Id method");
		OrderDetails order1 = repo.findById(orderId).orElse(null);
		if(order1==null) {
			return null;
		}else {
		return OrderDetailsUtils.convertToOrderDetailsDto(order1);
		}
	
		
	}
	/**
	 * 
	 * @author: sumanth
	 * Description:view order 
	 * date: 7/6/2021
	 * param:oderdetails  entity
	 * return :list<orderdetailsdto>
	 * 
	 */
	@Override
	public List<OrderDetailsDTO> viewAllOrdersByCustomer(Integer customerId) {
		logger.info("Inside service view all order by customer Id method");

		List<OrderDetails> order1 = repo.findAllOrdersByCustomer(customerId);
	     return OrderDetailsUtils.convertToOrderDetailsDtoList(order1);
	
	
	}
	/**
	 * 
	 * @author: sumanth
	 * Description:view order 
	 * date: 7/6/2021
	 * param:oderdetails  entity
	 * return :list<orderdetailsdto>
	 * 
	 */
	@Override
	public List<OrderDetailsDTO> viewAllOrdersByRestaurant(Integer id) {
		logger.info("Inside service view all order by restaurant name method");

		List<OrderDetails> list =repo.findAllByRestaurant(id);
		return OrderDetailsUtils.convertToOrderDetailsDtoList(list);
		

	}
	
}
