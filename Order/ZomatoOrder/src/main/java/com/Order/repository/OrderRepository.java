package com.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Order.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
