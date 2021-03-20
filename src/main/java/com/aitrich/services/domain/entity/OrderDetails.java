package com.aitrich.services.domain.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue
	private Long id;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
	
	private Long quantity;



	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId")
	private PurchaseOrder order;

	
	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}

	public OrderDetails(Long id, Product product, Long quantity, PurchaseOrder order) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.order = order;
	}

	public OrderDetails() {
		super();
	}

	public OrderDetails(Long id, Product product, Long quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	
	public OrderDetails( Product product, Long quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	
	
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", product=" + product + ", quantity=" + quantity +"]";
	}

	
}
