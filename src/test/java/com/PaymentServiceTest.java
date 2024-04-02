package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Ecommerce.dto.PaymentDTO;
import com.Ecommerce.entity.Orders;
import com.Ecommerce.entity.Payment;
import com.Ecommerce.repository.OrdersRepository;
import com.Ecommerce.repository.PaymentRepository;
import com.Ecommerce.serviceimpl.PaymentServiceImpl;

public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private OrdersRepository ordersRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMakePayment() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setAmount(100.0);
        paymentDTO.setOrderId(1);

        Orders order = new Orders();
        order.setOrderId(1);

        when(ordersRepository.findById(1)).thenReturn(java.util.Optional.of(order));

        Payment savedPayment = new Payment();
        savedPayment.setPaymentId(1);
        savedPayment.setAmount(100.0);
        savedPayment.setPaymentDate(LocalDateTime.now());
        savedPayment.setStatus("Pending");
        savedPayment.setOrder(order);

        when(paymentRepository.save(any(Payment.class))).thenReturn(savedPayment);

        PaymentDTO result = paymentService.makePayment(paymentDTO);

        assertNotNull(result);
        assertEquals(savedPayment.getPaymentId(), result.getPaymentId());
        assertEquals(savedPayment.getPaymentDate(), result.getPaymentDate());
        assertEquals(savedPayment.getStatus(), result.getStatus());

        verify(ordersRepository, times(1)).findById(1);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    public void testGetPaymentById() {
        int paymentId = 1;

        when(paymentRepository.findById(paymentId)).thenReturn(java.util.Optional.of(new Payment()));

        PaymentDTO result = paymentService.getPaymentById(paymentId);

        // Add assertions based on the actual implementation
        
  
    }
}

