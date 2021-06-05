package com.capg.foodonlinedelivery.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.OrderDetails;

public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {

	Optional<OrderDetails> findByOrderId(int id);

	List<OrderDetails> findByName(String restaurantName);

}
//