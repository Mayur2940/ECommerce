package com.Ecommerce.controller;

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
import com.Ecommerce.serviceimpl.CategoryServiceImpl;
import com.Ecommerce.serviceimpl.ProductServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired // For injecting the Spring Dependencies for invoking getters, setters,
				// constructors etc.
	private CategoryServiceImpl categoryServiceImpl;

	@PostMapping("/addCategory")
	public String addNewProduct(@RequestBody CategoryDTO categoryDTO) {
		categoryServiceImpl.addCategory(categoryDTO);
		return "Added Successfuly";
	}

	// Update all users
	@PutMapping("/updateCategory/{no}")
	public String updateCategory(@PathVariable(value = "no") int no, @RequestBody CategoryDTO categoryDTO) {
		categoryServiceImpl.updateCategory(no, categoryDTO);
		return "Updated Successfully";
	}

	// delete users
	@DeleteMapping("/deleteCategory/{no}")
	public String deleteCategory(@PathVariable(value = "no") int no) {
		categoryServiceImpl.removeCategory(no);
		return " Deleted Successfully";
	}

	@GetMapping("/categoryUsingName/{name}")
	public CategoryDTO getUserByEmail(@PathVariable(value = "name") String name) {
		return categoryServiceImpl.seachCategoryByName(name);
	}

	@GetMapping("/categoryUsingId/{id}")
	public CategoryDTO getUserByEmail(@PathVariable(value = "id") int id) {
		return categoryServiceImpl.searchCategoryById(id);
	}
}
