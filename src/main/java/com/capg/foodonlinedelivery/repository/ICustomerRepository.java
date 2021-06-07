package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.foodonlinedelivery.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from customer c where c.customerId=?1")
	public Customer findById(int customerId);

}
