package com.aitrich.services.product;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import com.aitrich.services.domain.entity.Category;
import com.aitrich.services.domain.entity.Product;
import com.aitrich.services.domain.repo.CategoryRepo;
import com.aitrich.services.domain.repo.ProductRepo;
import com.aitrich.services.product.requestDto.ProductDto;
import com.aitrich.services.product.requestDto.converter.ProductDtoToEntityMapper;
import io.smallrye.mutiny.Uni;


@ApplicationScoped
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Inject
	ProductRepo repo;
	
	@Inject
	ProductDtoToEntityMapper mapper;
	
	@Inject
	CategoryRepo categoryRepo;
	
	@Override
	@Transactional
	public Uni<ProductDto> save(ProductDto product) {
		
		Category category = categoryRepo.findByUUID(product.getCategoryId()).singleResult().await().indefinitely();
		Product pro = mapper.ToProductEntity(product);
		pro.setCategory(category);
		System.out.println("Product   : "+pro);
		
		return repo.persistAndFlush(pro).onItem().transform(item ->product);
	}

	@Override
	public Uni<Integer> update(String id, Product product) {
		
		
		return repo.update("productname =?1,category-categoryid =?2 where id =?3", product.getProductName(),product.getCategory().getCategoryId(),id);
	}

	@Override
	public Uni<Product> findById(String id) {
		
		return repo.find("id", id).singleResult();
	}

	@Override
	@Transactional
	public Uni<List<Product>> findAll() {
		
		return repo.findAll().list();
	}

	@Override
	public Uni<Long> delete(String id) {
		
		return repo.delete("id", id);
	}

}
