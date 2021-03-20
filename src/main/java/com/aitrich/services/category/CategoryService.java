package com.aitrich.services.category;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.Category;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface CategoryService {
	
	
	public Uni<Category> save(Category categories);
	
	public Uni<Integer> update(String id,Category category);
	
	public Uni<Category> findById(String id);
	
	public Uni<List<Category>> findAll();
	
	public Uni<Long> deleteCategoryById(String id);
	
	

}
