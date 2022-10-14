package com.Payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Payment.model.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long>{

}
