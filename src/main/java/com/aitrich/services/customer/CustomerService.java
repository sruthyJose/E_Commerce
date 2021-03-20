package com.aitrich.services.customer;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.Customer;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface CustomerService {
	
	Uni<Customer> create(Customer customer);
	Integer update(Customer customer,Long id);
	Uni<Customer> findById(Long id);
	Uni<List<Customer>> findAll();
	
	Uni<Boolean> deleteById(Long id);
	
 
}
