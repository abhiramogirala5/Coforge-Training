package com.coforge.pms.exception;


@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {

	@Override
	public String toString() {
		return "Product Not Found";
	}
	
}
