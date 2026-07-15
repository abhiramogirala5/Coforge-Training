package com.coforge.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coforge.config.BeanConfiguration;
import com.coforge.model.Student;

public class MyClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Student student = (Student) context.getBean("student1");
		System.out.println(student);
	}

}
