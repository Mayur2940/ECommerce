package com.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dto.PaymentDTO;
import com.Ecommerce.service.PaymentService;
import com.Ecommerce.serviceimpl.PaymentServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	 private final PaymentService paymentService;

	    @Autowired
	  // PaymentServiceImpl paymentServiceImpl;
	    public PaymentController(PaymentService paymentService) {
	       this.paymentService = paymentService;
	  }

	    @PostMapping("/make")
	    public ResponseEntity<PaymentDTO> makePayment(@RequestBody PaymentDTO paymentDTO) {
	        PaymentDTO responsePayment = paymentService.makePayment(paymentDTO);
	        return new ResponseEntity<>(responsePayment, HttpStatus.CREATED);
	    }

}
