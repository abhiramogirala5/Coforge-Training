package com.coforge.model;

public class DeliveryAddress {
	private String city;
	private String state;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public DeliveryAddress(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	public DeliveryAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DeliveryAddress [city=" + city + ", state=" + state + "]";
	}
	
	
}
