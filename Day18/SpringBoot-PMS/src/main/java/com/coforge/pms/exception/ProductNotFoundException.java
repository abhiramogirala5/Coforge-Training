package com.coforge.pms.exception;


@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
}
