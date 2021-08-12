package com.capg.foodonlinedelivery.controller;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.exceptionhandler.IdNotFoundException;
import com.capg.foodonlinedelivery.exceptionhandler.InvalidNameException;
import com.capg.foodonlinedelivery.exceptionhandler.RemoveFailedException;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;
import com.capg.foodonlinedelivery.service.ICartService;
import com.capg.foodonlinedelivery.service.IOrderService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Order")
public class OrderController {
	@Autowired
	IOrderService service;
	@Autowired
	ICartService cartService;

	org.slf4j.Logger logger=LoggerFactory.getLogger(OrderController.class);
	@PostMapping(value = "/add")
	public OrderDetailsDTO addOrder(@RequestBody OrderDetails order) {
		
		return service.addOrder(order);
	}
	
	@PutMapping(value = "/updateOrder")
	public ResponseEntity<OrderDetailsDTO> updateOrder(@Valid @RequestBody OrderDetails order) throws IdNotFoundException
	{
		logger.info("Inside update order method");
		OrderDetailsDTO order1=service.viewOrderById(order.getOrderId());
		if(order1==null)
		{
			throw new IdNotFoundException("Unable to update order due to invalid input !!!");
		}
		else
		{
			OrderDetailsDTO order2 =service.updateOrder(order);
			return new ResponseEntity<OrderDetailsDTO>(order2,HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping(value = "/removeOrderByOrderId/{orderId}")
	public  ResponseEntity<String> removeOrder(@PathVariable Integer orderId) throws RemoveFailedException 
	{
		   logger.info("Inside remove order method");
		   OrderDetailsDTO order1=service.viewOrderById(orderId);
	       if(order1==null)
		   {
	    	   throw new RemoveFailedException("Order removal failed !!!");
	       }
	       else
	       {
	    	   String msg=service.removeOrderById(orderId);
	    	   return new ResponseEntity<String>(msg, HttpStatus.OK);
	       }
	}
	
	@GetMapping(value = "/get/Restauant/{restaurantId}")

		
		public ResponseEntity<List<OrderDetailsDTO>> viewAllOrdersByRestaurant(@PathVariable Integer restaurantId) throws InvalidNameException 
		{
			logger.info("Inside view all order by restaurant name method");
			List<OrderDetailsDTO> order2 = service.viewAllOrdersByRestaurant(restaurantId);
			if(order2.isEmpty())
			{
				throw new InvalidNameException("Invalid restaurant name !!!");
			}
			else
			{
				return new ResponseEntity<List<OrderDetailsDTO>>(order2, HttpStatus.OK);

			}
		}
		

	
	@GetMapping(value = "/get/Customer/{customerId}")
	public ResponseEntity<List<OrderDetailsDTO>> viewAllOrdersByCustomer(@PathVariable Integer customerId) throws IdNotFoundException 
	{
		logger.info("Inside view all order by customer Id method");
		List<OrderDetailsDTO> order2 = service.viewAllOrdersByCustomer(customerId);
		if(order2.isEmpty())
		{
			throw new IdNotFoundException("Invalid customer !!!");
		}
		else
		{
			return new ResponseEntity<List<OrderDetailsDTO>>(order2, HttpStatus.OK);
		}
	}
	

}

