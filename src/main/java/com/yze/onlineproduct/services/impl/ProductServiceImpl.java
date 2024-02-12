package com.yze.onlineproduct.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.yze.onlineproduct.models.Product;
import com.yze.onlineproduct.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.yze.onlineproduct.dto.ProductDto;
import com.yze.onlineproduct.services.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Integer save(ProductDto dto) {
		Product product = ProductDto.toEntity(dto);
		return productRepository.save(product).getId();
	}

	@Override
	public Integer update(Integer id, ProductDto dto) {
		if (!productRepository.existsById(id)){
			throw new EntityNotFoundException("Product not found with provider ID :" + id);
		}
		Product product = ProductDto.toEntity(dto);
		product.setId(id);
		return productRepository.save(product).getId();
	}

	@Override
	public List<ProductDto> finAll() {
		return productRepository.findAll()
				.stream()
				.map(ProductDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto findById(Integer id) {
		return productRepository.findById(id)
				.map(ProductDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("not found with provider id : " +id ));
	}

	@Override
	public void delete(Integer id) {
		if (!productRepository.existsById(id)){
			throw new EntityNotFoundException("Product not found with provider ID :" + id);
		}
		productRepository.deleteById(id);
	}

}
