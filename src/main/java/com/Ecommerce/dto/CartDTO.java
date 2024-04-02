package com.Ecommerce.dto;

import java.util.List;

public class CartDTO {
	
	private int id;
	private List<ProductDTO> products;
	private UserDTO customer;
	private int totalQuantity;
	private double totalPrice;
	
	public CartDTO() {}
	public CartDTO(int id, List<ProductDTO> products, UserDTO customer, int totalQuantity, double totalPrice) {
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
		return "CartDTO [id=" + id + ", products=" + products + ", customer=" + customer + ", totalQuantity="
				+ totalQuantity + ", totalPrice=" + totalPrice + "]";
	}
	
	

}
