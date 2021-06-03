package com.capg.foodonlinedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.foodonlinedelivery.entities.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, String> {

}
