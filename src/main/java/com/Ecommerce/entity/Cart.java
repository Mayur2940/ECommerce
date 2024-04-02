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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany  // we have to check
	private List<Product> products = new ArrayList<Product>();
	@JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	

	

	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
	
	private int totalQuantity;
	private double totalPrice;
	
	
	
	public Cart() {}
	
	public Cart(int id, List<Product> products, CustomerEntity customer, int totalQuantity, double totalPrice) {
		super();
		this.id = id;
		this.products = products;
		this.customer = customer;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
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
	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + products + ", customer=" + customer + ", totalQuantity="
				+ totalQuantity + ", totalPrice=" + totalPrice + "]";
	}
	

}
