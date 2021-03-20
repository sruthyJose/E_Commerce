package com.aitrich.services.customer;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import com.aitrich.services.domain.entity.Customer;

import io.smallrye.mutiny.Uni;


@GraphQLApi
public class CustomerEndPoint {
	
	@Inject
	CustomerService customerService;
	
	@Mutation
	public Uni<Customer> customerInsert(Customer customer)
	{System.out.println("IN controller");
		return customerService.create(customer);
	}
	
	@Mutation
	public Integer update(Customer customer,Long id)
	{
		return customerService.update(customer,id);
	}

	@Query	
	public Uni<Customer>  findById(Long id)
	{
		return customerService.findById(id);
	}
	
	@Query
	public Uni<List<Customer>> findAll()
	{
		return customerService.findAll();
	}
	
	@Mutation
	public Uni<Boolean> delete(Long id)
	{
		return customerService.deleteById(id);
	}
	
	

}
