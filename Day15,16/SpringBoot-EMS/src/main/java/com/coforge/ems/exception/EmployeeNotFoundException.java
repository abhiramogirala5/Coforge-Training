package com.coforge.ems.exception;


@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {

	@Override
	public String toString() {
		return "Employee Not Found";
	}
	
}
