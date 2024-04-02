package com.Ecommerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private LocalDateTime date;
	private Status status ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	
	public Orders() {}

	public Orders(int orderId, LocalDateTime date, Status status, Cart cart) {
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", date=" + date + ", status=" + status + ", cart=" + cart + "]";
	}
	
	

}

