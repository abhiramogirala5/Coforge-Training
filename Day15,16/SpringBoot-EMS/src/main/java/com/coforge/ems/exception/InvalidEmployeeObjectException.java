package com.coforge.ems.exception;


@SuppressWarnings("serial")
public class InvalidEmployeeObjectException extends Exception {

	@Override
	public String toString() {
		return "Validation Failed";
	}
	
}
