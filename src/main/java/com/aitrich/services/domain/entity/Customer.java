package com.aitrich.services.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private long customerId;
	private String name;
	private String email;
	private String address;
	private Integer phoneNumber;
	
	
	public Customer() {
		super();
		
	}
	public Customer(long customerId, String name, String email, String address, Integer phoneNumber) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", Address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	

}
