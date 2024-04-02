package com.Ecommerce.service;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.ProductDTO;

public interface CartService {
	
	public CartDTO addToCart(int custid,int productid);
//	public CartDTO updateCart(CartDTO cartDTO);
	public String deleteProduct(int custid, int prodid);
	

}
