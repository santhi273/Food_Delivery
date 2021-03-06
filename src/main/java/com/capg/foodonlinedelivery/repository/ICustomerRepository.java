package com.capg.foodonlinedelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.foodonlinedelivery.entities.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.customerId=:id")
	public Optional<Customer> findById(@Param("id") Integer customerId);

}
