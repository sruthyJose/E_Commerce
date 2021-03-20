package com.aitrich.services.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name ="UUID",strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	private String productName;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Category category;
	
	private Long rate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", category=" + category + ", rate=" + rate + "]";
	}

	
	  public Product(String id, String productName, Category category) 
	  { 
		  super();
		  
	  this.id = id; 
	  this.productName = productName; 
	  this.category = category; 
	  }
	  
	  
	  public Product() {
		  super(); 
		  }

	public Product(String productId) {
		// TODO Auto-generated constructor stub
		 this.id = productId; 
	}
	 

	
	

}
