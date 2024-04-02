package com.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.dto.ProductDTO;
import com.Ecommerce.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findByBrand(String brandName);

}
