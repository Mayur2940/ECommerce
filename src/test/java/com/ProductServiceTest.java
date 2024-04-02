package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Ecommerce.dto.ProductDTO;
import com.Ecommerce.entity.Cart;
import com.Ecommerce.entity.CustomerEntity;
import com.Ecommerce.entity.Product;
import com.Ecommerce.repository.CustomerRepository;
import com.Ecommerce.repository.ProductRepository;
import com.Ecommerce.serviceimpl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testAddProduct() {
        // Arrange
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand("TestBrand");
        productDTO.setProductId(1);

        Product product = new Product();
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act
        ProductDTO result = productService.addProduct(productDTO);

        // Assert
        assertEquals(productDTO, result);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testGetById() {
        // Arrange
        int productId = 1;
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Act
        ProductDTO result = productService.getById(productId);

        // Assert
        assertEquals(product.getBrand(), result.getBrand());
        assertEquals(product.getCategory(), result.getCategory());
        // Assert other properties...

        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testUpdateProduct() {
        // Arrange
        int productId = 1;
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("UpdatedName");
        productDTO.setBrand("UpdatedBrand");
       

        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act
        ProductDTO result = productService.updateProduct(productId, productDTO);

        // Assert
        assertEquals(productDTO, result);
        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testDeleteProduct() {
        // Arrange
        int productId = 1;

        // Act
        boolean result = productService.deleteProduct(productId);

        // Assert
        assertTrue(result);
        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Product> products = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(products);

        // Act
        List<ProductDTO> result = productService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductByBrand() {
        // Arrange
        String brandName = "TestBrand";
        List<Product> products = new ArrayList<>();
        when(productRepository.findByBrand(brandName)).thenReturn(products);

        // Act
        List<ProductDTO> result = productService.getProductByBrand(brandName);

        // Assert
        assertNotNull(result);
        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findByBrand(brandName);
    }

    @Test
    void testGetProductByCustomer() {
        // Arrange
        int customerId = 1;
        CustomerEntity customer = new CustomerEntity();
        Cart cart = new Cart();
        List<Product> products = new ArrayList<>();
        cart.setProducts(products);
        customer.setCart(cart);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        // Act
        List<ProductDTO> result = productService.getProductByCustomer(customerId);

        // Assert
        assertNotNull(result);
        assertEquals(products.size(), result.size());
        verify(customerRepository, times(1)).findById(customerId);
    }
}

