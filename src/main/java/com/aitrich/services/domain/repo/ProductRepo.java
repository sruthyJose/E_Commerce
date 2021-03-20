package com.aitrich.services.domain.repo;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.Product;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;


@ApplicationScoped
public class ProductRepo implements PanacheRepository<Product> {

}
