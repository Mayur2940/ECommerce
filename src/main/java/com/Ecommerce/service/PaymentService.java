package com.Ecommerce.service;

import org.springframework.stereotype.Service;

import com.Ecommerce.dto.PaymentDTO;

@Service
public interface PaymentService {
	 PaymentDTO makePayment(PaymentDTO paymentDTO);
	 PaymentDTO getPaymentById(int paymentId);

}
