package com.yze.onlineproduct.services;


import com.yze.onlineproduct.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    Integer save(CategoryDto dto);

    Integer update(Integer id, CategoryDto dto);

    List<CategoryDto> finAll();

    CategoryDto findById(Integer id);

    void delete(Integer id);

}
