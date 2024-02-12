package com.yze.onlineproduct.dto;

import com.yze.onlineproduct.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryDto {

    private Integer code;
    private String label;
    private String description;


    public static CategoryDto fromEntity(Category category){
        return CategoryDto.builder()
                .code(category.getCode())
                .label(category.getLabel())
                .description(category.getDescription())
                .build();
        }

    public static Category toEntity(CategoryDto categoryDto){
        return Category.builder()
                .code(categoryDto.getCode())
                .label(categoryDto.getLabel())
                .description(categoryDto.getDescription())
                .build();
    }
}
