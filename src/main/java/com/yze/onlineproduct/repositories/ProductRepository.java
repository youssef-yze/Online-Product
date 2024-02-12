package com.yze.onlineproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yze.onlineproduct.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
