package com.Order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Order.model.Orders;
import com.Order.repository.OrderRepository;


@Service
public class OrderService 
{
	@Autowired
	private OrderRepository repo;
	
	public Orders getCustomer(Long id)
	{
		List<Orders> cus = repo.findAll();	
		return cus.stream()
				.filter(c -> c.getId()
				.equals(id))
				.findAny()
				.orElse(null);	
	}
}
