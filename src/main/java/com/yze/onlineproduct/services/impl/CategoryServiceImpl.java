package com.yze.onlineproduct.services.impl;

import com.yze.onlineproduct.dto.CategoryDto;
import com.yze.onlineproduct.models.Category;
import com.yze.onlineproduct.repositories.CategoryRepository;
import com.yze.onlineproduct.services.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Integer save(CategoryDto dto) {
        Category category = CategoryDto.toEntity(dto);
        return categoryRepository.save(category).getId();
    }

    @Override
    public Integer update(Integer id, CategoryDto dto) {
        if (!categoryRepository.existsById(id)){
            throw new EntityNotFoundException("Category not found with the provider Id :" + id);
        }
        Category category = CategoryDto.toEntity(dto);
        category.setId(id);
        return categoryRepository.save(category).getId();
    }

    @Override
    public List<CategoryDto> finAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Category not found with the provider Id :" + id));
    }

    @Override
    public void delete(Integer id) {
        if (!categoryRepository.existsById(id)){
            throw new EntityNotFoundException("Category not found with the provider Id :" + id);
        }
        categoryRepository.deleteById(id);
    }
}
