package com.Ecommerce.dto;

import com.Ecommerce.entity.Category;


public class ProductDTO {
	
	private int productId;
	private String productName;
	private double productPrice;
	private String productImage;
	private int quantity;
	private Category category;
	private String brand;
	
	public ProductDTO() {}
	
	public ProductDTO(int productId, String productName, double productPrice, String productImage, int quantity,
			Category category, String brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.quantity = quantity;
		this.category = category;
		this.brand = brand;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productImage=" + productImage + ", quantity=" + quantity + ", category=" + category + ", brand="
				+ brand + "]";
	}
	

}
