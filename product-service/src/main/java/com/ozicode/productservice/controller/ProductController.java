package com.ozicode.productservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozicode.productservice.entity.Product;
import com.ozicode.productservice.service.abstracts.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());				
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.saveProduct(product));
	}

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.updateProduct(product));
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Product>> findProductsByCategory(@PathVariable String category) {
		return ResponseEntity.ok(productService.findProductsByCategory(category));
	}

	@GetMapping("/price/{minPrice}/{maxPrice}")
	public ResponseEntity<List<Product>> findProductsByPrice(@PathVariable Float minPrice, @PathVariable Float maxPrice) {
		return ResponseEntity.ok(productService.findProductsByPrice(minPrice, maxPrice));
	}

	@GetMapping("/stock/{minStock}/{maxStock}")
	public ResponseEntity<List<Product>> findProductsByStock(@PathVariable Integer minStock, @PathVariable Integer maxStock) {
		return ResponseEntity.ok(productService.findProductsByStock(minStock, maxStock));
	}

}
