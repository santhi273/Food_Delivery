package com.capg.foodonlinedelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.OrderDetails;
@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {


	

	@Query("select o from OrderDetails o where o.customer.customerId=:id")
	public List<OrderDetails> findAllOrdersByCustomer(@Param("id") Integer id);

	
	@Query("select o from OrderDetails o where o.restaurant.restaurantId="
			+ "(select r.restaurantId from Restaurant r where r.restaurantId=:id)")
	public List<OrderDetails> findAllByRestaurant(@Param("id") Integer id);
	
	public List<OrderDetails> findByList_ItemId(int itemId);
}