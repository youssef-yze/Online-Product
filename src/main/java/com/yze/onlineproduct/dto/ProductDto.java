package com.yze.onlineproduct.dto;

import java.math.BigDecimal;

import com.yze.onlineproduct.models.Category;
import com.yze.onlineproduct.models.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder

public class ProductDto {
	
	private Integer id;
	private String code;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer quantity;
	private String inventoryStatus;
	private Category category;
	private String image;
	private Integer rating;
	
	
	public static ProductDto fromEntity(Product product) {
		 return ProductDto.builder()
	                .id(product.getId())
	                .code(product.getCode())
	                .name(product.getName())
	                .description(product.getDescription())
	                .price(product.getPrice())
	                .quantity(product.getQuantity())
	                .inventoryStatus(product.getInventoryStatus())
	                .category(Category.builder().id(product.getId()).build())
	                .image(product.getImage())
	                .rating(product.getRating())
	                .build();
	}

	public static Product toEntity(ProductDto productDto) {
		return Product.builder()
				.id(productDto.getId())
				.code(productDto.getCode())
				.name(productDto.getName())
				.description(productDto.getDescription())
				.price(productDto.getPrice())
				.quantity(productDto.getQuantity())
				.inventoryStatus(productDto.getInventoryStatus())
				.category(Category.builder().id(productDto.getId()).build())
				.image(productDto.getImage())
				.rating(productDto.getRating())
				.build();
	}

}
