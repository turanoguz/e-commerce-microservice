package com.ozicode.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozicode.productservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	List<Order> findAllByCustomerId(Integer customerId);

	List<Order> findAllByOrderStatus(String orderStatus);

}
