package com.aitrich.services.product.requestDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductDto {
	
	private String name;
	private Long rate;
	private String categoryId;
	
	public ProductDto(String name, Long rate, String categoryId) {
		super();
		this.name = name;
		this.rate = rate;
		this.categoryId = categoryId;
	}
	public ProductDto() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRate() {
		return rate;
	}
	public void setRate(Long rate) {
		this.rate = rate;
	}
	public String getCategoryId() {
		return categoryId;
	}
	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", rate=" + rate + ", categoryId=" + categoryId + "]";
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	

}
