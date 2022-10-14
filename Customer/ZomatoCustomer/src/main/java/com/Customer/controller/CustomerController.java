package com.Customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Customer.Repository.CustomerRepository;
import com.Customer.model.Customer;
import com.Customer.model.Orders;
import com.Customer.model.Payments;
import com.Customer.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	
	
	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public Customer addDetail(@RequestBody Customer cus)
	{
		log.info("Adding customer details");
		return repo.save(cus);
	}
	
	@GetMapping("/getall")
	public List<Customer> getDetails()
	{
		log.info("Getting all customer details");
		return repo.findAll();
	}
	
	@RequestMapping("/get/{id}")
	public Customer getDetail(@PathVariable Long id)
	{
		log.info("Getting a particular customer detail by id");
		Customer cus = service.getCustomer(id);	
		return cus;	
	}
	
	@PutMapping("/update")
	public Customer putDetail(@RequestBody Customer cus)
	{
		log.info("Updating customer details");
		return repo.save(cus);
	}
	
	@DeleteMapping("/delete/{cId}")
	public void delete(@PathVariable Long cId)
	{
		log.info("Deleting customer detail by id "+cId);
		repo.deleteById(cId);
	}
	
	@GetMapping("/myorder/{cId}")
	public String getAll(@PathVariable Long cId) 
	{
		log.info("Get all orders for customer "+cId);
		
		Customer cus = service.getCustomer(cId);
		
		try {
		Payments pa=this.restTemplate.getForObject("http://payment/payment/getbycusId/"+cId,Payments.class);
		
		Orders or = this.restTemplate.getForObject("http://order/order/get/"+pa.getoId(),Orders.class);
		
		String str="<h1> HI<br>"+cus.getCname()+"<br>YourOrders<br>"+or.getProductname()+"...... "+or.getProductprice()+"<br>";
		
		return str;
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return ("<h1>OOPS....</h1>");

	}
}
