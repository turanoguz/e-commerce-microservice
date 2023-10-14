package com.ozicode.productservice.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ozicode.productservice.entity.Order;
import com.ozicode.productservice.repository.OrderRepository;
import com.ozicode.productservice.service.abtracts.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;

	@CacheEvict(value = "orders", allEntries = true)
	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@CacheEvict(value = "products", allEntries = true)
	@Override
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}

	@Cacheable(value = "prudcts", key = "#id")
	@Override
	public Order getOrder(Integer id) {
		return orderRepository.findById(id).orElse(null);
	}

	@Cacheable(value = "products")
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Cacheable(value = "prudcts", key = "#customerId")
	@Override
	public List<Order> getOrdersByCustomerId(Integer customerId) {
		return orderRepository.findAllByCustomerId(customerId);
	}

	@Cacheable(value = "prudcts", key = "#orderStatus")
	@Override
	public List<Order> getOrdersByStatus(String orderStatus) {
		return orderRepository.findAllByOrderStatus(orderStatus);
	}

	@KafkaListener(topics = "product-topic", groupId = "order-group")
	public void order(String productName) {
		System.out.println("yeni ürün eklendi.." + " " + productName);
	}

}
