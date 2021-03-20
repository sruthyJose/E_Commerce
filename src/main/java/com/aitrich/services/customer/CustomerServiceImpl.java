package com.aitrich.services.customer;

import java.util.List;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.aitrich.services.domain.entity.Customer;
import com.aitrich.services.domain.repo.CustomerRepo;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.UniAwait;



@ApplicationScoped
public class CustomerServiceImpl implements CustomerService{
	
	@Inject
	CustomerRepo customerRepo;

	@Override
	public Uni<Customer> create(Customer customer) {
		
		System.out.println("IN Service"+customer);
		return customerRepo.persist(customer).chain(customerRepo :: flush)
				.onItem().transform(item ->customer);
	}

	@Override
	public Integer update(Customer customer,Long id) {
		
		//Uni<Customer> c= customerRepo.findById(id);
		//Customer c =customerRepo.findById(id).await().indefinitely();   to convert uni to object
		System.out.println("DDDDDDDDDDDdd");
		Integer a =customerRepo.update("name =?1, email = ?2, address = ?3, phoneNumber =?4 where customerId = ?5", customer.getName(),customer.getEmail(),customer.getAddress(),customer.getPhoneNumber(),id).await().indefinitely();
		System.out.println("DDDDDDDDDDDdd "+a);
		return a;
	}

	@Override
	public Uni<Customer> findById(Long id) {
		
		return customerRepo.findById(id);
	}

	@Override
	public Uni<List<Customer>> findAll() {
		
		return customerRepo.findAll().list();
	}

	@Override
	public Uni<Boolean> deleteById(Long id) {
		 
		return customerRepo.deleteById(id);
	}

}
