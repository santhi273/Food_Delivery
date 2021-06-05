package com.capg.foodonlinedelivery.utils;

import java.util.ArrayList;
import java.util.List;

import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.model.OrderDetailsDTO;

public class OrderDetailsUtils {

	public static List<OrderDetailsDTO> convertToOrderDetailsDtoList(List<OrderDetails> list){
		List<OrderDetailsDTO> dtolist = new ArrayList<OrderDetailsDTO>();
		for(OrderDetails OrderDetails : list) 
			dtolist.add(convertToOrderDetailsDto(OrderDetails));
		return dtolist;
	}
	
	public static OrderDetails convertToOrderDetails(OrderDetailsDTO OrderDetailsdto) {
		OrderDetails OrderDetails = new OrderDetails();
		OrderDetails.setOrderId(OrderDetailsdto.getOrderId());
		OrderDetails.setOrderDate(OrderDetailsdto.getOrderDate());
		OrderDetails.setOrderStatus(OrderDetailsdto.getOrderStatus());
		return OrderDetails;
	}
	
	
		public static OrderDetailsDTO convertToOrderDetailsDto(OrderDetails OrderDetails) {
			OrderDetailsDTO OrderDetailsdto = new OrderDetailsDTO();
			OrderDetailsdto.setOrderId(OrderDetails.getOrderId());
			OrderDetailsdto.setOrderDate(OrderDetails.getOrderDate());
			OrderDetailsdto.setOrderStatus(OrderDetails.getOrderStatus());
			OrderDetailsdto.setCart(OrderDetails.getCart());
			
			return OrderDetailsdto;
		}
		
}
//

