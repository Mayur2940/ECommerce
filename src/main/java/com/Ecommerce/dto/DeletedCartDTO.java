package com.Ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

public class DeletedCartDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int orderid;

	@ManyToMany
	@JoinTable(name = "deletedcart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<ProductDTO> products = new ArrayList<ProductDTO>();

	@OneToOne
	@JoinColumn(name = "customer_id")
	private UserDTO customer;	

	private int totalQuantity;
	private double totalPrice;
	public DeletedCartDTO(int id, int orderid, List<ProductDTO> products, UserDTO customer, int totalQuantity,
			double totalPrice) {
		super();
		this.id = id;
		this.orderid = orderid;
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
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	public UserDTO getCustomer() {
		return customer;
	}
	public void setCustomer(UserDTO customer) {
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
		return "DeletedCartDTO [id=" + id + ", orderid=" + orderid + ", products=" + products + ", customer=" + customer
				+ ", totalQuantity=" + totalQuantity + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
