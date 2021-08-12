package com.capg.foodonlinedelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.FoodCart;
import com.capg.foodonlinedelivery.model.CustomerDTO;
import com.capg.foodonlinedelivery.repository.ICartRepository;
import com.capg.foodonlinedelivery.repository.ICustomerRepository;
import com.capg.foodonlinedelivery.repository.IOrderRepository;
import com.capg.foodonlinedelivery.utils.CustomerUtils;
/**
 * 
 * @author: mithila
 * Description: customer service implementation
 * date: 7/6/2021
 * param:customer  entity,
 *
 */
@Service
public class CustomerServiceImplement implements ICustomerService {
	
	@Autowired
	ICustomerRepository repo;
	@Autowired
	ICartRepository repo1;
	@Autowired
	IOrderRepository orderRepository;
	Logger logger=LoggerFactory.getLogger(CustomerServiceImplement.class);
	/**
	 * 
	 * @author: mithila
	 * Description: add customer 
	 * date: 7/6/2021
	 * param:customer  entity,
	 * return:customerdto 
	 */
	@Override
	public CustomerDTO addCustomer(Customer customer) {
		
		logger.info("Inside service add customer method");
		Customer customer1 = repo.save(customer);
		FoodCart cart = new FoodCart();
		cart.setCustomer(customer1);
		repo1.save(cart);
        
		return CustomerUtils.convertToCustomerDto(customer1);
		
	}
	/**
	 * 
	 * @author: mithila
	 * Description: update customer 
	 * date: 7/6/2021
	 * param:customer  entity,
	 * return:customerdto 
	 */
	@Override
	public CustomerDTO updateCustomer(Customer customer) {
        
		logger.info("Inside service update customer method");
		Customer customer1 = repo.saveAndFlush(customer);
		return CustomerUtils.convertToCustomerDto(customer1);
		 
	}
	/**
	 * 
	 * @author: mithila
	 * Description: view customer 
	 * date: 7/6/2021
	 * param:customer  entity
	 * return:List<customerDto> 
	 */
	@Override
	public List<CustomerDTO> viewAllCustomers() {
        
		logger.info("Inside service view all customers");
		List<Customer> list = repo.findAll();
		return CustomerUtils.convertToCustomerDtoList(list);
		 
	}
	/**
	 * 
	 * @author: mithila
	 * Description: view customer 
	 * date: 7/6/2021
	 * param:customer  entity
	 * return:customerDto 
	 */
	@Override
	
	public CustomerDTO viewCustomerById(Integer customerId) {
		
		logger.info("Inside service view customer by Id method");
		Customer customer = repo.findById(customerId).orElse(null);
		if(customer==null) {
			return null;
		}
		else {
		return CustomerUtils.convertToCustomerDto(customer);
		}
	}
	/**
	 * 
	 * @author: mithila
	 * Description: delete customer 
	 * date: 7/6/2021
	 * param:customer  entity,
	 * return:string 
	 */
	@Override
	public String deleteCustomerById(Integer customerId) {
		
		logger.info("Inside service delete customer method");
		
		Customer customer=repo.getById(customerId);
		FoodCart cart=repo1.findByCustomer_CustomerId(customerId);
		cart.setCustomer(null);
		cart.setItemList(null);
		repo1.save(cart);
		repo1.deleteById(cart.getCartId());
		repo.deleteById(customerId);
		return "Customer Deleted Successfully";
	}

}
