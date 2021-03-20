package com.aitrich.services.order.requestDto.converter;

import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.aitrich.services.domain.entity.Customer;
import com.aitrich.services.domain.entity.PurchaseOrder;
import com.aitrich.services.domain.entity.OrderDetails;
import com.aitrich.services.domain.entity.Product;
import com.aitrich.services.domain.repo.CustomerRepo;
import com.aitrich.services.domain.repo.ProductRepo;
import com.aitrich.services.order.requestDto.OrderDto;

@ApplicationScoped
public class OrderRequestConverter {

	@Inject
	ProductRepo productRepo;

	@Inject
	CustomerRepo customerRepo;

	public PurchaseOrder convert(OrderDto orderDto) {
		
		  PurchaseOrder orderEntity = new PurchaseOrder(
		  customerRepo.findById(orderDto.getCustomerId()).await(). indefinitely() );
		 
		// Set<OrderDetails> orderDetails= new HashSet<OrderDetails>();

		orderDto.getOrderDetailsDto().forEach(item -> 
		orderEntity.addOrderDetails(new OrderDetails(productRepo.find("id", item.getProductId()).singleResult().await().indefinitely(), item.getQuantity())));
		orderEntity.setDate(LocalDateTime.now());
		

		return orderEntity;

	}

}
