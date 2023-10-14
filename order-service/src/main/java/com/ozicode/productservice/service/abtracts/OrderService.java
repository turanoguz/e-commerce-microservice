package com.ozicode.productservice.service.abtracts;

import java.util.List;

import com.ozicode.productservice.entity.Order;

public interface OrderService {
	Order createOrder(Order order);

	Order updateOrder(Order order);

	Order getOrder(Integer id);

	List<Order> getAllOrders();

	List<Order> getOrdersByCustomerId(Integer customerId);

	List<Order> getOrdersByStatus(String orderStatus);

}
