package com.Ecommerce.service;

import java.util.List;

import com.Ecommerce.dto.ProductDTO;

public interface ProductService {
	
	public ProductDTO getById(int id);
	public ProductDTO updateProduct(int id,ProductDTO productDTO);
	public boolean deleteProduct(int no);
	public ProductDTO addProduct(ProductDTO productDTO);
	public List<ProductDTO> findAll();
	public List<ProductDTO> getProductByCustomer(int customerId);
	public List<ProductDTO> getProductByBrand(String brandName);
	

}
