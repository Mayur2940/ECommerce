package com.Ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.dto.CategoryDTO;
import com.Ecommerce.entity.Category;
import com.Ecommerce.repository.CategoryRepository;
import com.Ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public String addCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		categoryRepository.save(category);
		return "Category Added Successfully";

	}

	public String updateCategory(int categoryId, CategoryDTO categoryDTO) {
		Category category = categoryRepository.findById(categoryId).get();
		category.setCategoryName(categoryDTO.getCategoryName());

		categoryRepository.save(category);
		return "Updated Successfully";

	}

	public String removeCategory(int categoryId) {

		categoryRepository.deleteById(categoryId);
		return "Deleted Successfully";
	}

	public CategoryDTO seachCategoryByName(String name) {

		Category category = categoryRepository.findByCategoryName(name);

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());

		return categoryDTO;
	}

	public CategoryDTO searchCategoryById(int id) {
		Category category = categoryRepository.findById(id).get();

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());

		return categoryDTO;

	}
}
