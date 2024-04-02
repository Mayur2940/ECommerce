package com.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dto.CategoryDTO;
import com.Ecommerce.dto.ProductDTO;
import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.entity.Product;
import com.Ecommerce.serviceimpl.CustomerServiceImpl;
import com.Ecommerce.serviceimpl.ProductServiceImpl;

@RestController
@RequestMapping("/product") 
public class ProductController {
	
	
	@Autowired // For injecting the Spring Dependencies for invoking getters, setters, constructors etc.
	private ProductServiceImpl productServiceImpl;
	
	
	//User Register
		@PostMapping("/addProduct")
		public ProductDTO addNewProduct(@RequestBody ProductDTO productDTO) 
		{
			return productServiceImpl.addProduct(productDTO);
		}
//		// Read all user
//		@GetMapping("/allUsers")
//		public List<UserDTO> readAllUsers() 
//		{
//			return userService.readAllUsers();
//		}
//		// Update all users
//		@PutMapping("/updateUser/{no}")
//		public String updateUser(@PathVariable(value = "no") int no, @RequestBody UserDTO user) 
//		{
//			return userService.updateUser(no, user);
//		}
//		//delete users
//		@DeleteMapping("/deleteUser/{no}")
//		public String deleteUser(@PathVariable(value = "no") int no) 
//		{
//			userService.deleteUser(no);
//			return "The User_Id:- " + no + " is Deleted Successfully";
//		}
//		
//		// Read all user
//				@GetMapping("/userByEmail/{email}")
//				public UserDTO getUserByEmail(@PathVariable(value = "email") String email) 
//				{
//					return userService.getByEmail(email);
//				}
//	
		
		@GetMapping("/getById/{id}")
		public ProductDTO getProductById(@PathVariable(value = "id") int id) 
		{
			return productServiceImpl.getById(id);
		}
		
		@PutMapping("/updateProduct/{no}")
		public ProductDTO updateProduct(@PathVariable(value = "no") int no, @RequestBody ProductDTO product) 
		{
			productServiceImpl.updateProduct(no, product);
			 return product;
		}
		//delete users
		@DeleteMapping("/deleteProduct/{no}")
		public boolean deleteProduct(@PathVariable(value = "no") int no) 
		{
			productServiceImpl.deleteProduct(no);
			
			return true;
		}
		
		@GetMapping("/getByBrand/{name}")
		public List<ProductDTO> getProductById(@PathVariable(value = "name") String name) {
			return productServiceImpl.getProductByBrand(name);
		}

		
		@GetMapping("/getProduct/{custid}")
		public List<ProductDTO> getCart(@PathVariable(value = "custid") int custid) {
			return productServiceImpl.getProductByCustomer(custid);
		}
		
		
	

}
