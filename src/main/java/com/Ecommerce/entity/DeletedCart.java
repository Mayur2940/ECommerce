package com.Ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="deletedCart")
public class DeletedCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany
	@JoinTable(name = "deletedcart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<Product>();

	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;	
	private int totalQuantity;
	private double totalPrice;
	private int orderid;
	
	public DeletedCart() {}
	
	public DeletedCart(int id, List<Product> products, CustomerEntity customer, int totalQuantity, double totalPrice,
			int orderid) {
		super();
		this.id = id;
		this.products = products;
		this.customer = customer;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.orderid = orderid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "DeletedCart [id=" + id + ", products=" + products + ", customer=" + customer + ", totalQuantity="
				+ totalQuantity + ", totalPrice=" + totalPrice + ", orderid=" + orderid + "]";
	}
	

}
