package com.aitrich.services.order;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import com.aitrich.services.domain.entity.PurchaseOrder;
import com.aitrich.services.order.requestDto.OrderDto;
import com.aitrich.services.order.requestDto.converter.OrderRequestConverter;

import io.smallrye.mutiny.Uni;

@GraphQLApi
public class OrderResourceEndPoint {
	
	@Inject
	OrderRequestConverter converter;
	
	@Inject
	OrderService orderService;
	
	
	
	@Mutation
	public Uni<PurchaseOrder> placeOrder(OrderDto orderDto)
	{
		
		
		return orderService.addOrder(converter.convert(orderDto));
		
	}
	
	@Query 
	public Uni<List<PurchaseOrder>> findAllOrders()
	{
		return orderService.findAll();
	}
	
	@Mutation
	public Uni<Boolean> deleteOrderById(String orderId)
	{
		return orderService.deleteOrderById(orderId);
	}
	
	
	@Mutation
	public Uni<PurchaseOrder> cancelAnItemFromOrder(String orderId,String productId)
	{
		return orderService.cancelProducctFromOrder(orderId, productId);
		
	}

	
}
