package com.capg.foodonlinedelivery.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.entities.Items;
import com.capg.foodonlinedelivery.entities.OrderDetails;
import com.capg.foodonlinedelivery.entities.Payment;
import com.capg.foodonlinedelivery.model.PaymentDTO;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
import com.capg.foodonlinedelivery.repository.IPaymentRepository;
import com.capg.foodonlinedelivery.utils.PaymentUtils;
/**
 * 
 * @author: hemalatha
 * Description:payment service Implementation 
 * date: 7/6/2021
 * param:payment entity
 * 
 */
@Service
public class PaymentServiceImplement implements IPaymentService {
	@Autowired
	IPaymentRepository repository;
	@Autowired
	IOrderRepository orderRepository;
	FoodCart foodcart;
	Logger logger=LoggerFactory.getLogger(PaymentServiceImplement.class);
	/**
	 * 
	 * @author: hemalatha
	 * Description:add payment  
	 * date: 7/6/2021
	 * param:payment entity
	 * return paymentDTO
	 */
	@Override
	public PaymentDTO addPayment(Integer orderId) {
		logger.info("Inside service add payment method");
		OrderDetails order=orderRepository.getById(orderId);
		Payment payment=new Payment();
		List<Items> list=order.getList();
		int totalItems=list.size();
		double sum=0.0;
		for(int i=0;i<totalItems;i++) {
			Items item=list.get(i);
			sum+=item.getCost();
		}
		payment.setPaymentDate(order.getOrderDate());
		payment.setOrder(order);
		payment.setTotalItem(totalItems);
		payment.setTotalCost(sum);
       Payment payment1=repository.save(payment);
        return PaymentUtils.convertToPaymentDto(payment1);
	}
	/**
	 * 
	 * @author: hemalatha
	 * Description:UPDATE payment  
	 * date: 7/6/2021
	 * param:payment entity
	 * return paymentDTO
	 */
	@Override
	public PaymentDTO updatePayment(Payment payment) {
		logger.info("Inside service update payment method");
        Payment payment1 = repository.save(payment);
		return  PaymentUtils.convertToPaymentDto(payment1);
	}
	
	/**
	 * 
	 * @author: hemalatha
	 * Description:view payment  
	 * date: 7/6/2021
	 * param:payment entity
	 * return paymentDTO
	 */
   @Override
	public PaymentDTO viewPaymentById(Integer paymentId) {
		logger.info("Inside service view payment By Id method");
		Payment payment1 = repository.findById(paymentId).orElse(null);
		if(payment1==null) {
			return null;
		}
		return PaymentUtils.convertToPaymentDto(payment1);
	}
   /**
	 * 
	 * @author: hemalatha
	 * Description:add payment  
	 * date: 7/6/2021
	 * param:payment entity
	 * return: list<paymentDTO>
	 */
	@Override
	public List<PaymentDTO> viewPaymentByCustomerId(int customerId) {
		logger.info("Inside service view payment by customer Id method");
		List<Payment> list = repository.findByOrderCustomerCustomerId(customerId);
		return PaymentUtils.convertToPaymentDtoList(list);
	}
	/**
	 * 
	 * @author: hemalatha
	 * Description:total cost  
	 * date: 7/6/2021
	 * param:payment entity
	 * return: Double
	 */
	@Override
	public Double calculateTotalCost(Payment payment) {
		logger.info("Inside service calculate total cost method");
		return payment.getTotalCost();
	
	}

	
}
