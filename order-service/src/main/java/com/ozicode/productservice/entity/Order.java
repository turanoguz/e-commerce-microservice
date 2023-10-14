package com.ozicode.productservice.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "customer_id")
    private Integer customerId;
	
	@Column(name = "product_id")
    private List<Integer> productId;
	
	@Column(name = "product_quantities")
    private List<Integer> productQuantities;
	
	@Column(name = "total_price")
    private Float totalPrice;
	
	@Column(name = "order_status")
    private String orderStatus;

}
