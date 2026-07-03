package com.coforge.day3;

public class StudentApp {

	public static void main(String[] args) {
		Student s = new Student();
		s.setsId(101);
		s.setSemail("abc@gmail.com");
		s.setsName("abc");
		
		System.out.println(s);
		
		s.toString();

	}

}
