package com.Ecommerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

  @Entity
  @Table(name = "payments")
  public class Payment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int paymentId;
	    private double amount;
	    private LocalDateTime paymentDate;
	    private String status;

	    @OneToOne
	    @JoinColumn(name = "order_id")
	    private Orders order;

	    public Payment() {
	    }

	    public Payment(int paymentId, double amount, LocalDateTime paymentDate, String status, Orders order) {
	        this.paymentId = paymentId;
	        this.amount = amount;
	        this.paymentDate = paymentDate;
	        this.status = status;
	        this.order = order;
	    }

	    public int getPaymentId() {
	        return paymentId;
	    }

	    public void setPaymentId(int paymentId) {
	        this.paymentId = paymentId;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public LocalDateTime getPaymentDate() {
	        return paymentDate;
	    }

	    public void setPaymentDate(LocalDateTime paymentDate) {
	        this.paymentDate = paymentDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public Orders getOrder() {
	        return order;
	    }

	    public void setOrder(Orders order) {
	        this.order = order;
	    }

	    @Override
	    public String toString() {
	        return "Payment{" + "paymentId=" + paymentId + ", amount=" + amount + ", paymentDate=" + 
	                paymentDate + ", status='" + status + '\'' + ", order=" + order +'}';
	    }
	}
