package com.yze.onlineproduct.services;

import java.util.List;



import com.yze.onlineproduct.dto.ProductDto;


public interface ProductService {
	
	Integer save(ProductDto dto);
	
	Integer update(Integer id,ProductDto dto);
	
	List<ProductDto> finAll();
	
	ProductDto findById(Integer id);
	
	void delete(Integer id);

}
