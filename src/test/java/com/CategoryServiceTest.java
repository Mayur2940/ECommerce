package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Ecommerce.dto.CategoryDTO;
import com.Ecommerce.entity.Category;
import com.Ecommerce.repository.CategoryRepository;
import com.Ecommerce.serviceimpl.CategoryServiceImpl;

public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCategory() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(1);
        categoryDTO.setCategoryName("Electronics");

        when(categoryRepository.save(any(Category.class))).thenReturn(new Category());

        String result = categoryService.addCategory(categoryDTO);

        assertEquals("Category Added Successfully", result);
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    public void testUpdateCategory() {
        int categoryId = 1;
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(categoryId);
        categoryDTO.setCategoryName("Updated Electronics");

        Category category = new Category();
        category.setCategoryId(categoryId);

        when(categoryRepository.findById(categoryId)).thenReturn(java.util.Optional.of(category));
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        String result = categoryService.updateCategory(categoryId, categoryDTO);

        assertEquals("Updated Successfully", result);
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    public void testRemoveCategory() {
        int categoryId = 1;

        categoryService.removeCategory(categoryId);

        verify(categoryRepository, times(1)).deleteById(categoryId);
    }

    @Test
    public void testSearchCategoryByName() {
        String categoryName = "Electronics";

        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName(categoryName);

        when(categoryRepository.findByCategoryName(categoryName)).thenReturn(category);

        CategoryDTO result = categoryService.seachCategoryByName(categoryName);

        assertNotNull(result);
        assertEquals(category.getCategoryId(), result.getCategoryId());
        assertEquals(category.getCategoryName(), result.getCategoryName());
    }

    @Test
    public void testSearchCategoryById() {
        int categoryId = 1;

        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName("Electronics");

        when(categoryRepository.findById(categoryId)).thenReturn(java.util.Optional.of(category));

        CategoryDTO result = categoryService.searchCategoryById(categoryId);

        assertNotNull(result);
        assertEquals(category.getCategoryId(), result.getCategoryId());
        assertEquals(category.getCategoryName(), result.getCategoryName());
    }
}
