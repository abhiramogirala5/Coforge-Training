package com.coforge.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coforge.model.Customer;
import com.coforge.model.DeliveryAddress;

@Configuration
public class BeanConfiguration {
	
	@Bean(name = "customer1")
	public Customer getCustomer1() {
		Customer customer = new Customer();
		customer.setCustomerId(101);
		customer.setCustomerName("Bunny");
		customer.setEmails(Arrays.asList("bunny@gmail.com" , "bunny1@gmail.com"));
		customer.setDeliveryAddress(Arrays.asList(getDeliveryAddress1() , getDeliveryAddress2()));
		return customer;
	}
	
	@Bean(name = "deliveryAddress1")
	public DeliveryAddress getDeliveryAddress1() {
		DeliveryAddress deliveryAddress1 = new DeliveryAddress();
		deliveryAddress1.setCity("City-1");
		deliveryAddress1.setState("State-1");
		return deliveryAddress1;
	}
	
	@Bean(name = "deliveryAddress2")
	public DeliveryAddress getDeliveryAddress2() {
		DeliveryAddress deliveryAddress2 = new DeliveryAddress("City-2" , "State-2");
		return deliveryAddress2;
	}
}
