package com.ozicode.productservice.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ozicode.productservice.entity.Product;
import com.ozicode.productservice.repository.ProductRepository;
import com.ozicode.productservice.service.abstracts.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	private final KafkaTemplate<String, String> kafkaTemplate;

//	@CacheEvict(value = "products", allEntries = true)
//	public void save(Product product) {
//		productRepository.save(product);
//		kafkaTemplate.send("product-topic", product.getName());
//	}
//
//	@Cacheable(value = "products")
//	public List<Product> getAll() {
//		return productRepository.findAll();
//	}
//
//	@Cacheable(value = "prudcts", key = "#id")
//	public Product getById(int id) {
//		return productRepository.findById(id).orElseThrow();
//	}

	@CacheEvict(value = "products", allEntries = true)
	@Override
	public Product saveProduct(Product product) {
		kafkaTemplate.send("product-topic", product.getName());
		return productRepository.save(product);
	}

	@CacheEvict(value = "products", allEntries = true)
	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@CacheEvict(value = "products", allEntries = true)
	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Cacheable(value = "products")
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Cacheable(value = "prudcts", key = "#category")
	@Override
	public List<Product> findProductsByCategory(String category) {
		return productRepository.findAllByCategory(category);
	}

	@Cacheable(value = "products")
	@Override
	public List<Product> findProductsByPrice(Float minPrice, Float maxPrice) {
		return productRepository.findAllByPriceBetween(minPrice, maxPrice);
	}

	@Cacheable(value = "products")
	@Override
	public List<Product> findProductsByStock(int minStock, int maxStock) {
		return productRepository.findAllByStockBetween(minStock, maxStock);
	}

	@Cacheable(value = "prudcts", key = "#id")
	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).orElseThrow();
	}

}
