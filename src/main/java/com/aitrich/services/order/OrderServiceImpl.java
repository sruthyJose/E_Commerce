package com.aitrich.services.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.reactive.mutiny.Mutiny;

import com.aitrich.services.domain.entity.OrderDetails;
import com.aitrich.services.domain.entity.PurchaseOrder;
import com.aitrich.services.domain.repo.OrderRepo;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Inject
	OrderRepo orderRepo;
	
	@Inject
	Mutiny.Session session;
	

	@Override
	public Uni<PurchaseOrder> addOrder(PurchaseOrder order) {
		
		System.out.println("addOrder"+order);
		
		
		return orderRepo.persistAndFlush(order).onItem().transform(item ->order);
	}

	

	@Override

	public Uni<PurchaseOrder> cancelProducctFromOrder(String orderId, String productId) {
		
		
		PurchaseOrder order = orderRepo.findById(orderId).await().indefinitely();
		System.out.println("AAAAAAA "+order);
		Set<OrderDetails> orderDetails= new HashSet<OrderDetails>();
		orderDetails =order.getOrderDetails();
		System.out.println("BBBBBBBBBBB "+orderDetails);
		//Stream<OrderDetails> stream = orderDetails.stream();
		
		//stream.forEach(item->item.getProduct().getId().compareTo(productId));
		
		//stream.filter(item ->!item.getProduct().getId().equals(productId)).collect(Collectors.toSet());
		//orderDetails.forEach(n -> item.getProduct().getId().compareTo(productId)
		//order.setOrderDetails(stream.filter(item ->!item.getProduct().getId().equals(productId)).collect(Collectors.toSet()));
		
//		orderDetails.forEach(or -> 
//			{
//			if(or.getProduct().getId().equals(productId))
//			{
//				order.addOrderDetails(new OrderDetails());
//				//order.removeOrder(or);
//			//orderDetails.remove(or);
//	
//			}});
//		
		for(Iterator<OrderDetails> od = orderDetails.iterator(); od.hasNext();)
		{
			OrderDetails orderDetailsObj=od.next();
			if(orderDetailsObj.getProduct().getId().equals(productId))
			{
				System.out.println("entered");
				//order.addOrderDetails(new OrderDetails());
				//orderDetailsObj.setQuantity(100000L);
				order.removeOrder(orderDetailsObj);
				//od.remove();
				break;
			}	
		}
		//order.setOrderId(null);
		//session.merge(order);
//		
		System.out.println("FFFFFFFFFFFFF "+order);
		//Uni<OrderEntity> orderupdated=addOrder(order);
		//System.out.println("Updated "+orderupdated);
		//orderupdated.await().indefinitely().getOrderDetails().removeIf(n->n.getProduct().getId().equals(productId));
		//System.out.println("DDDDDDD  " +orderupdated.await().indefinitely().getOrderDetails());
		//return orderRepo.persistAndFlush(order).onItem().transform(item->order);
			
		//orderRepo.delete("orderdetils =?1 where orderid = ?2", order.getOrderDetails(),order.getOrderId());
		
		return session.merge(order).chain(session :: flush).onItem().transform(ignore -> order);
		//return orderupdated;
	}



	@Override
	public Uni<Boolean> deleteOrderById(String id) {
		
		return orderRepo.deleteById(id).chain(orderRepo::flush).onItem().transform(ignore -> true);
	}



	@Override
	public Uni<List<PurchaseOrder>> findAll() {
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		return orderRepo.findAll().list();
	}

}
