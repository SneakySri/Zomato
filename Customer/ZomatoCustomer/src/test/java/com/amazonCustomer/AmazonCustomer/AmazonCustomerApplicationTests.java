package com.amazonCustomer.AmazonCustomer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Customer.Repository.CustomerRepository;
import com.Customer.model.Customer;
import com.Customer.service.CustomerService;



@SpringBootTest
@RunWith(Parameterized.class)
class AmazonCustomerApplicationTests {

	@Autowired
	private CustomerService ser;
	
	@MockBean
	private CustomerRepository repo;
	
	
	@Test
	public void check() {
		
		assertEquals(1,1);
	}
	
	
	
	@Test
	public void testgetCustomer() {
		Customer cus=new Customer(1L,"perumbakkam","7448867464","sri");	
		assertEquals(cus,ser.getCustomer(1L));
	}
	
	
	
	

}
