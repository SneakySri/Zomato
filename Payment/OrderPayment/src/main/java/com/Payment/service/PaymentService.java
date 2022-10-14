package com.Payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Payment.model.Payments;
import com.Payment.repository.PaymentRepository;

@Service
public class PaymentService 
{
	@Autowired
	private PaymentRepository repo;
	
	public Payments getdetails(Long id) 
	{
		List<Payments> users = repo.findAll();
		
		return users.stream().filter(customer -> customer.getpId().equals(id)).findAny().orElse(null);
		
	}
}
