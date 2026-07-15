package com.coforge.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coforge.model.Address;
import com.coforge.model.Student;

@Configuration
public class BeanConfiguration {
	
	@Bean(name = "student1")
	public Student student1() {
		Student student = new Student();
		student.setstudentId(101);
		student.setStudentName("Bunny");
		student.setSubjects(Arrays.asList("Java" , "Spring Core" , "Hibernate" , "MySQL" , "React"));
		Set <String> set = new HashSet<>(Arrays.asList("Communication" , "Problem Solving" , "Team Work" , "Java"));
		student.setSkills(set);
		String[] subs = {"Java" , "Spring Core" , "Hibernate" , "MySQL" , "React"};
		int[] marks = {95 , 90 , 88 , 92 , 85};
		Map<String , Integer> marksMap = new HashMap<>();
		for(int i = 0 ; i < subs.length ; i++) {
			marksMap.put(subs[i], marks[i]);
		}
		student.setMarks(marksMap);
		student.setAddress(address1());
		return student;
	}
	
	@Bean(name = "address1")
	public Address address1() {
		Address address = new Address();
		address.setCity("City-1");
		address.setState("State-1");
		return address;
	}
}
