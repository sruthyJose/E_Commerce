package com.aitrich.services.category;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.aitrich.services.domain.entity.Category;
import com.aitrich.services.domain.repo.CategoryRepo;

import io.smallrye.mutiny.Uni;


@ApplicationScoped
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	  @Inject
	  CategoryRepo categoryRepo;

	@Override
	public Uni<Category> save(Category categories) {
		System.out.println("GFGFGfdyhfytuytuyu");
		
		return categoryRepo.persistAndFlush(categories)
				.onItem().transform(ignore ->categories);
	}

	@Override
	public Uni<Integer> update(String id, Category category) {
		
		return categoryRepo.update("categoryname =?1 where id = ?2", category.getCategoryName(),id);
	}

	@Override
	public Uni<Category> findById(String id) {
		
		return categoryRepo.find("categoryid", id).singleResult();
	}

	@Override
	public Uni<List<Category>> findAll() {
		
		return categoryRepo.findAll().list();
	}

	@Override
	public Uni<Long> deleteCategoryById(String id) {
		return categoryRepo.delete("categoryid",id);
	}

}
