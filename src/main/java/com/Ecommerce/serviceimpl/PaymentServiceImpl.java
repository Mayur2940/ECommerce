package com.Ecommerce.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.dto.PaymentDTO;
import com.Ecommerce.entity.Orders;
import com.Ecommerce.entity.Payment;
import com.Ecommerce.repository.OrdersRepository;
import com.Ecommerce.repository.PaymentRepository;
import com.Ecommerce.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	 private final PaymentRepository paymentRepository;
	 private final OrdersRepository ordersRepository;
	 
	 @Autowired
	 public PaymentServiceImpl(PaymentRepository paymentRepository, OrdersRepository ordersRepository) {
	     this.paymentRepository = paymentRepository;
	     this.ordersRepository = ordersRepository;
	 }

	   @Override
	   public PaymentDTO makePayment(PaymentDTO paymentDTO) {
		
		    Payment payment = new Payment();
	        payment.setAmount(paymentDTO.getAmount());
	        payment.setPaymentDate(LocalDateTime.now());
	        payment.setStatus("Pending"); // Initial status
	        // Assuming orderId is provided in the DTO
	        Orders order = ordersRepository.findById(paymentDTO.getOrderId()).orElse(null);
	        payment.setOrder(order);

	        Payment savedPayment = paymentRepository.save(payment);

	        paymentDTO.setPaymentId(savedPayment.getPaymentId());
	        paymentDTO.setPaymentDate(savedPayment.getPaymentDate());
	        paymentDTO.setStatus(savedPayment.getStatus());

	        return paymentDTO;
	}

	@Override
	public PaymentDTO getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
