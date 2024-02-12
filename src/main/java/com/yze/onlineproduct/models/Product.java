package com.yze.onlineproduct.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data

public class Product extends AbsractEntity{
	
	private String code;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer quantity;
	private String inventoryStatus;
	private String image;
	private Integer rating;

	@ManyToOne()
	@JoinColumn(name = "id_category")
	private Category category;

}
