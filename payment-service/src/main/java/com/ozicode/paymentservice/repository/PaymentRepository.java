package com.ozicode.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozicode.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
