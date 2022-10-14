package com.Payment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Payment.model.Customer;
import com.Payment.model.Orders;
import com.Payment.model.PaymentDetails;
import com.Payment.model.Payments;
import com.Payment.repository.PaymentRepository;
import com.Payment.service.PaymentService;



@RestController
@RequestMapping("/payment")
public class PaymentController 
{
	Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService service;
	
	@Autowired
	private PaymentRepository repo;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<Payments> addAll(@RequestBody Payments pay)
	{
		log.info("Adding payment details");
		return ResponseEntity.ok(((CrudRepository<Payments, Long>) repo).save(pay));
	}
	
	@RequestMapping("/getbycusId/{cId}")
	public Payments getByCusId(@PathVariable Long cId) 
	{
		log.info("get payment using cId");
		
		List<Payments> list=repo.findAll();
		
		Payments pay=list.stream()
				.filter(p->p.getcId().equals(cId))
				.findAny()
				.orElse(null);
		
		return pay;
		
	}
	
	@RequestMapping("/get/{pId}")
	public PaymentDetails getdetails(@PathVariable ("pId") Long id)
	{
		log.info("Getting payment details by id");
		PaymentDetails pd = new PaymentDetails();
		try
		{
		Payments pay = service.getdetails(id);
		pd.setPayment(pay);
		
		Customer cus = this.restTemplate.getForObject("http://customer/customer/get/"+pay.getcId(),Customer.class);
		pd.setCustomer(cus);

		Orders or = this.restTemplate.getForObject("http://order/order/get/"+pay.getoId(),Orders.class);
		pd.setOrders(or);
		}
		
		
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return pd;
	}
}
