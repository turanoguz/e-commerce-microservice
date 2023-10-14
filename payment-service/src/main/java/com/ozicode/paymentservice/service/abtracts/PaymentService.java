package com.ozicode.paymentservice.service.abtracts;

import java.util.List;

import com.ozicode.paymentservice.entity.Payment;

public interface PaymentService {

	/**
	 * Bir ödeme oluşturur.
	 *
	 * @param payment Ödeme nesnesi
	 * @return Oluşturulan ödeme nesnesi
	 */
	Payment createPayment(Payment payment);

	/**
	 * Bir ödemeyi günceller.
	 *
	 * @param payment Ödeme nesnesi
	 * @return Güncellenen ödeme nesnesi
	 */
	Payment updatePayment(Payment payment);

	/**
	 * Belirli bir ödemeyi döndürür.
	 *
	 * @param id Ödeme kimliği
	 * @return Belirtilen ödeme nesnesi
	 */
	Payment getPayment(Integer id);

	/**
	 * Tüm ödemeleri döndürür.
	 *
	 * @return Tüm ödemelerin listesi
	 */
	List<Payment> getAllPayments();
}
