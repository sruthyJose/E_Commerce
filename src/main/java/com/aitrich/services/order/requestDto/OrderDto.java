package com.aitrich.services.order.requestDto;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderDto {
	
	
	private Long customerId;
	private List<OrderDetailDto> orderDetailsDto;
	
	
	@Override
	public String toString() {
		return "OrderDto [customerId=" + customerId + ", orderDetailsDto=" + orderDetailsDto + "]";
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public List<OrderDetailDto> getOrderDetailsDto() {
		return orderDetailsDto;
	}


	public void setOrderDetailsDto(List<OrderDetailDto> orderDetailsDto) {
		this.orderDetailsDto = orderDetailsDto;
	}


	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderDto(Long customerId, List<OrderDetailDto> orderDetailsDto) {
		super();
		this.customerId = customerId;
		this.orderDetailsDto = orderDetailsDto;
	}
	

}
