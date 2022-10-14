package com.Customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Customer.Repository.CustomerRepository;
import com.Customer.model.Customer;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository repo;
	
	
	

	public Customer getCustomer(Long id)
	{
		List<Customer> cus = repo.findAll();	
		Customer cu = cus.stream().filter(c -> c.getcId().equals(id)).findAny().orElse(null);	
		return cu;
	}
}
