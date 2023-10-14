package com.ozicode.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozicode.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByCategory(String category);

	List<Product> findAllByPriceBetween(Float minPrice, Float maxPrice);

	List<Product> findAllByStockBetween(Integer minStock, Integer maxStock);

}
