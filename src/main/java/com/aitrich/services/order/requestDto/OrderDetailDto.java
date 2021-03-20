package com.aitrich.services.order.requestDto;

public class OrderDetailDto {
	
	private String productId;
	private Long quantity;
	public OrderDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailDto(String productId, Long quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetailDto [productId=" + productId + ", quantity=" + quantity + "]";
	}
	
}
