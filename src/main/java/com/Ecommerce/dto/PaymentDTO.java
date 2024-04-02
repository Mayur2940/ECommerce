package com.Ecommerce.dto;

import java.time.LocalDateTime;

public class PaymentDTO {
	 private int paymentId;
	    private double amount;
	    private LocalDateTime paymentDate;
	    private String status;
	    private int orderId;
	    
	    public PaymentDTO() {}

		public PaymentDTO(int paymentId, double amount, LocalDateTime paymentDate, String status, int orderId) {
			super();
			this.paymentId = paymentId;
			this.amount = amount;
			this.paymentDate = paymentDate;
			this.status = status;
			this.orderId = orderId;
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

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		@Override
		public String toString() {
			return "PaymentDTO [paymentId=" + paymentId + ", amount=" + amount + ", paymentDate=" + paymentDate
					+ ", status=" + status + ", orderId=" + orderId + "]";
		}

}
