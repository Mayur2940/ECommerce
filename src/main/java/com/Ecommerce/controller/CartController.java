package com.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.serviceimpl.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired // For injecting the Spring Dependencies for invoking getters, setters,
	// constructors etc.
	CartServiceImpl cartServiceImpl;

//	@PostMapping("/addCart")
//	public CartDTO addCart(@RequestBody CartDTO cartDTO) {
//		return cartServiceImpl.addToCart(cartDTO);
//	}

	@PostMapping("/add")
	public ResponseEntity<String> addToCart(@RequestParam int customerId, @RequestParam int productId) {
		cartServiceImpl.addToCart(customerId, productId);
		return ResponseEntity.ok("Product added to cart successfully.");

	}
	
	// delete users
		@DeleteMapping("/deleteProducts")
		public String deleteProductCart(@RequestParam int customerId, @RequestParam int productId) {
			cartServiceImpl.deleteProduct(customerId,productId);
			return "deleted successfully";
		}
}
