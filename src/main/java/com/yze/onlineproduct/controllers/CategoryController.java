package com.yze.onlineproduct.controllers;

import com.yze.onlineproduct.dto.CategoryDto;
import com.yze.onlineproduct.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Tag(name = "category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Integer> saveCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAllCategory(){
        return ResponseEntity.ok(categoryService.finAll());
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable("idCategory") Integer id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping("/{idCategory}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable("idCategory") Integer id){
        categoryService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("{idCategory}")
    public ResponseEntity<Integer> updateCategoryById(@PathVariable("idCategory") Integer id,@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.update(id, categoryDto));
    }

}
