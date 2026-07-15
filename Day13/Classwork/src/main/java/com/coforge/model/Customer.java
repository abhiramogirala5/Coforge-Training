package com.coforge.model;

import java.util.List;

public class Customer {
	private int customerId;
	private String customerName;
	private List<String> emails;
	private List<DeliveryAddress> deliveryAddress;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public List<DeliveryAddress> getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(List<DeliveryAddress> deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public Customer(int customerId, String customerName, List<String> emails, List<DeliveryAddress> deliveryAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emails = emails;
		this.deliveryAddress = deliveryAddress;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", emails=" + emails
				+ ", deliveryAddress=" + deliveryAddress + "]";
	}
	
}
