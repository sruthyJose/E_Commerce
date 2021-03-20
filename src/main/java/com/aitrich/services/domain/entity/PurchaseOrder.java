package com.aitrich.services.domain.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
	private String orderId;

	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	@OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "order")
	@JsonIgnore
	//@JsonbTransient
	private Set<OrderDetails> orderDetails=new HashSet<OrderDetails>();
	
	private LocalDateTime date;

	public PurchaseOrder() {
		super();
		
	}

	public PurchaseOrder(String orderId, Customer customer, Set<OrderDetails> orderDetails, LocalDateTime date) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.date = date;
	}
	
	public PurchaseOrder(Customer customer, Set<OrderDetails> orderDetails, LocalDateTime date) {
		super();
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.date = date;
	}
	public PurchaseOrder(Customer customer) 
	{
		this.customer = customer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public void addOrderDetails(OrderDetails details)
	{
		orderDetails.add(details);
		details.setOrder(this);
	}
	
	public void removeOrder(OrderDetails details)
	{
		orderDetails.remove(details);
		details.setOrder(null);
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", orderDetails=" + orderDetails + ", date="
				+ date + "]";
	}
	
	
	
}
