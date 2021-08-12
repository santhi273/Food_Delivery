package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.CustomerLogin;

public interface ICustomerLoginRepository extends JpaRepository<CustomerLogin, Integer> {

	public CustomerLogin findByUserName(String userName);

}
