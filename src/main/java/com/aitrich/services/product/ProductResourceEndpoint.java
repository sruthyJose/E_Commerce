package com.aitrich.services.product;


import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import com.aitrich.services.domain.entity.Product;
import com.aitrich.services.product.requestDto.ProductDto;

import io.smallrye.mutiny.Uni;

@GraphQLApi
public class ProductResourceEndpoint {
	
	@Inject
	ProductService service;
	
	@Mutation
	public Uni<ProductDto> insert(ProductDto productDto)
	{
		return service.save(productDto);
	}
	
	@Mutation
	public Uni<Integer> updateProduct(String id, Product product)
	{
		return service.update(id,product);
	}
	
	
	@Mutation
	public Uni<Long> deleteProduct(String id)
	{
		return service.delete(id);
	}
	
	@Query
	public Uni<Product> findProduct(String id)
	{
		return service.findById(id);
	}
	
	@Query
	public Uni<List<Product>> findAllProduct()
	{
		return  service.findAll();
	}
	

}
