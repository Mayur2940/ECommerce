package com.Ecommerce.dto;

import java.time.LocalDateTime;

import com.Ecommerce.entity.Cart;
import com.Ecommerce.entity.Status;


public class OrdersDTO {
	
	private int orderId;
	private LocalDateTime date;
	private Status status;
	private CartDTO cart;
	
	public OrdersDTO() {}
	
	public OrdersDTO(int orderId, LocalDateTime date, Status status, CartDTO cart) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.status = status;
		this.cart = cart;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public CartDTO getCart() {
		return cart;
	}
	public void setCart(CartDTO cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "OrdersDTO [orderId=" + orderId + ", date=" + date + ", status=" + status + ", cart=" + cart + "]";
	}
	

}
