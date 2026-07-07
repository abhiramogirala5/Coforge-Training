package com.coforge.ems.exception;

import com.coforge.ems.util.ApplicationProperties;

@SuppressWarnings("serial")
public class InvalidEmployeeObjectException extends Exception {

	@Override
	public String toString() {
		return ApplicationProperties.validationFailed;
	}
	
}
