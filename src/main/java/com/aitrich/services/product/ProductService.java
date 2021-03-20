package com.aitrich.services.product;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.Product;
import com.aitrich.services.product.requestDto.ProductDto;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface ProductService {
	
	Uni<ProductDto> save(ProductDto product);
	 
	Uni<Integer> update(String id, Product product);
	Uni<Product> findById(String id);
	Uni<List<Product>> findAll();

	Uni<Long> delete(String id);
	
}
