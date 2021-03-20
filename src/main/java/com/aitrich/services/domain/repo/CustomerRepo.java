package com.aitrich.services.domain.repo;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.Customer;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

@ApplicationScoped
public class CustomerRepo implements PanacheRepository<Customer>{

}
