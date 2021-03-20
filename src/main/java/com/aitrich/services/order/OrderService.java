package com.aitrich.services.order;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.PurchaseOrder;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface OrderService {
	
	public Uni<PurchaseOrder> addOrder(PurchaseOrder order);
	
	public Uni<PurchaseOrder> cancelProducctFromOrder(String orderId, String productId);
	
	public Uni<Boolean> deleteOrderById(String id);
	
	public Uni<List<PurchaseOrder>> findAll();

}
