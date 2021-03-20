package com.aitrich.services.domain.repo;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.services.domain.entity.Category;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;



@ApplicationScoped
public class CategoryRepo implements PanacheRepository<Category>{
	
	public PanacheQuery<Category> findByUUID(String id)
	{
		return find("categoryid", id); 
	}

}
