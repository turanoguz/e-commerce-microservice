package com.ozicode.productservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozicode.productservice.entity.Order;
import com.ozicode.productservice.service.abtracts.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		Order createdOrder = orderService.createOrder(order);
		return ResponseEntity.ok(createdOrder);
	}

	@PutMapping
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		Order updatedOrder = orderService.updateOrder(order);
		return ResponseEntity.ok(updatedOrder);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Integer id) {
		Order order = orderService.getOrder(id);
		return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		return orders != null ? ResponseEntity.ok(orders) : ResponseEntity.notFound().build();
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable Integer customerId) {
		List<Order> orders = orderService.getOrdersByCustomerId(customerId);
		return orders != null ? ResponseEntity.ok(orders) : ResponseEntity.notFound().build();
	}

	@GetMapping("/status/{orderStatus}")
	public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable String orderStatus) {
		List<Order> orders = orderService.getOrdersByStatus(orderStatus);
		return orders != null ? ResponseEntity.ok(orders) : ResponseEntity.notFound().build();
	}
}
