package com.coforge.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coforge.config.BeanConfiguration;
import com.coforge.model.Customer;


public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Customer customer = (Customer) context.getBean("customer1");
		System.out.println(customer);
		
		
		
	}

}
