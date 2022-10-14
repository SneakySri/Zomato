package com.Order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Order.model.Orders;
import com.Order.repository.OrderRepository;
import com.Order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/add")
	public Orders addDetail(@RequestBody Orders cus)
	{
		log.info("Adding order details");
		return repo.save(cus);
	}
	
	@GetMapping("/getall")
	public List<Orders> getDetails()
	{
		log.info("Getting order details");
		return repo.findAll();
	}
	
	@RequestMapping("/get/{id}")
	public Orders getDetail(@PathVariable Long id)
	{
		log.info("Getting a order detail by id");
		Orders cus = service.getCustomer(id);	
		return cus;		
	}
	
	@PutMapping("/update")
	public Orders putDetail(@RequestBody Orders cus)
	{
		log.info("Updating order details");
		return repo.save(cus);
	}
	
	@DeleteMapping("/delete/{cId}")
	public void delete(@PathVariable Long cId)
	{
		log.info("Deleting a order detail by id");
		repo.deleteById(cId);
	}
}
