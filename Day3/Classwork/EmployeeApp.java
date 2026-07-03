package com.coforge.day3;

public class EmployeeApp {

	public static void main(String[] args) {
		Employee Abhi = new Employee(101,"Abhi",5000.0);
		Abhi.display();

		Abhi.setSalary(10000.0);
		Abhi.display();
		
		Employee Ramesh = new Employee(102,"Ramesh",4000.0);
		Ramesh.display();
	}

}
