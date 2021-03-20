package com.aitrich.services.product.requestDto.converter;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.aitrich.services.domain.entity.Category;
import com.aitrich.services.domain.entity.Product;
import com.aitrich.services.product.requestDto.ProductDto;

//@ApplicationScoped
@Mapper(config  = QuarkusMappingConfig.class)
public interface ProductDtoToEntityMapper {
	
	
	ProductDtoToEntityMapper mapper = Mappers.getMapper(ProductDtoToEntityMapper.class);

	
	  @Mapping(target = "rate", source= "rate")
	  
	  @Mapping(target = "productName" ,source = "name")
	  
	//  @Mapping(target ="category", source = "categoryId")
	 
	Product ToProductEntity(ProductDto pr);
	
}
