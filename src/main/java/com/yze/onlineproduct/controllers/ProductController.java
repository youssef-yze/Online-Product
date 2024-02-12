package com.yze.onlineproduct.controllers;

import com.yze.onlineproduct.dto.ProductDto;
import com.yze.onlineproduct.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> saveProduct(@RequestBody ProductDto product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProduct(){
        return ResponseEntity.ok(productService.finAll());
    }

    @GetMapping("/{id-product}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id-product") Integer id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{id-product}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id-product") Integer id){
        productService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/{id-product}")
    public ResponseEntity<Integer> updateProduct(
            @PathVariable("id-product") Integer id,
            @RequestBody ProductDto product
    ){
        Integer rs = productService.update(id,product);
        if (rs == -1){
            return ResponseEntity.notFound().build();
        }else {
            return  ResponseEntity.ok(rs);
        }
    }

}
