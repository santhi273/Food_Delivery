package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.OrderDetails;

public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {

}
