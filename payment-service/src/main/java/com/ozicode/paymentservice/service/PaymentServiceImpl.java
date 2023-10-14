package com.ozicode.paymentservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ozicode.paymentservice.entity.Payment;
import com.ozicode.paymentservice.repository.PaymentRepository;
import com.ozicode.paymentservice.service.abtracts.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	private final PaymentRepository paymentRepository;

	@Override
	public Payment createPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPayment(Integer id) {
		return paymentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

}
