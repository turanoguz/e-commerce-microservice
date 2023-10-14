package com.ozicode.productservice.service.abstracts;

import java.util.List;

import com.ozicode.productservice.entity.Product;

public interface ProductService {
	Product saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(int productId);

	List<Product> getAllProducts();

	List<Product> findProductsByCategory(String category);

	List<Product> findProductsByPrice(Float minPrice, Float maxPrice);

	List<Product> findProductsByStock(int minStock, int maxStock);

	Product getProductById(int id);

}
