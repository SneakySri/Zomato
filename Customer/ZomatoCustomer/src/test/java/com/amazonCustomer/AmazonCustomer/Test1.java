package com.amazonCustomer.AmazonCustomer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.Customer.model.Customer;
import com.Customer.service.CustomerService;
import com.Customer.springsecurity.UserRepository;

public class Test1 {
	
	
	
	
	@Test
	public void check() {
		
		assertEquals(1,1);
	}
	
	
	@Test
	public void testgetCustomer() {
		CustomerService ser=new CustomerService();
		Customer cus=new Customer(1L,"perumbakkam","7448867464","sri");	
		
		when(ser.getCustomer(1L)).thenReturn(cus);
		assertEquals(cus,ser.getCustomer(1L));
		verify(ser).getCustomer(1L);
	}

}
