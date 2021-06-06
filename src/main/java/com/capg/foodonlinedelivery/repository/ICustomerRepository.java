package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findById(int customerId);

}
