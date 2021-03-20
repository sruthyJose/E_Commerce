package com.aitrich.services.domain.repo;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.PurchaseOrder;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
@ApplicationScoped
public class OrderRepo implements PanacheRepositoryBase<PurchaseOrder,String>{

}
