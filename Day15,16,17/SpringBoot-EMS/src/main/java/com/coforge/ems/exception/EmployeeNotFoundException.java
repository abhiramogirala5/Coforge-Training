package com.coforge.ems.exception;


@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {

	
	public EmployeeNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
}
