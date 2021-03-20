package com.aitrich.services.category;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;


import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import com.aitrich.services.domain.entity.Category;

import io.smallrye.mutiny.Uni;

@GraphQLApi
public class CategoryResourceEndPoint {
	
	
	
	@Inject
	CategoryService categoryService;
	
 
    
	@Mutation
    public Uni<Category> addCategory(Category category)
    {
		System.out.println("DFDFD");
    	 return categoryService.save(category);
    	
    }
	
	
	@Mutation
	public Uni<Integer> updateCategory(String  id, Category category )
	{
		return categoryService.update(id, category);
	}
	
	@Query
	public Uni<List<Category>> findAllCategory()
	{
		
		return categoryService.findAll();
	}
	
	@Query
	public Uni<Category> findByUUID(String id)
	{
		return categoryService.findById(id);
	}
	
	@Mutation 
	public Uni<Long> deleteCategory(String id)
	{
		System.out.println("FGFG");
		return categoryService.deleteCategoryById(id);
	}
	
	
    
    
}