package com.Ecommerce.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.dto.ProductDTO;
import com.Ecommerce.entity.Cart;
import com.Ecommerce.entity.CustomerEntity;
import com.Ecommerce.entity.Product;
import com.Ecommerce.repository.CustomerRepository;
import com.Ecommerce.repository.ProductRepository;
import com.Ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	public ProductDTO addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setBrand(productDTO.getBrand());
		product.setCategory(productDTO.getCategory());
		product.setProductId(productDTO.getProductId());
		product.setProductImage(productDTO.getProductImage());
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
		product.setQuantity(productDTO.getQuantity());

		productRepository.save(product);
		return productDTO;
	}

	public ProductDTO getById(int id) {
		Product product = productRepository.findById(id).get();

		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand(product.getBrand());
		productDTO.setCategory(product.getCategory());
		productDTO.setProductId(product.getProductId());
		productDTO.setProductImage(product.getProductImage());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setQuantity(product.getQuantity());

		return productDTO;

	}

	public ProductDTO updateProduct(int id, ProductDTO productDTO) {

		Product product = productRepository.findById(id).get();
		product.setProductName(productDTO.getProductName());
		product.setBrand(productDTO.getBrand());
		product.setCategory(productDTO.getCategory());
		product.setProductImage(productDTO.getProductImage());
		product.setProductPrice(productDTO.getProductPrice());
		product.setQuantity(productDTO.getQuantity());

		productRepository.save(product);
		return productDTO;

	}

	public boolean deleteProduct(int id) {

		productRepository.deleteById(id);
		return true;

	}

	public List<ProductDTO> findAll() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setBrand(product.getBrand());
			productDTO.setCategory(product.getCategory());
			productDTO.setProductId(product.getProductId());
			productDTO.setProductImage(product.getProductImage());
			productDTO.setProductName(product.getProductName());
			productDTO.setProductPrice(product.getProductPrice());
			productDTO.setQuantity(product.getQuantity());

			productDTOs.add(productDTO);
		}
		return productDTOs;

	}

//	public List<ProductDTO> getProductByCustomer(int customerId){
//		
//		
//		
//	}
	public List<ProductDTO> getProductByBrand(String brandName) {

		List<Product> products = productRepository.findByBrand(brandName);

		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();

		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setCategory(product.getCategory());
			productDTO.setBrand(brandName);
			productDTO.setProductId(product.getProductId());
			productDTO.setProductImage(product.getProductImage());
			productDTO.setProductName(product.getProductName());
			productDTO.setProductPrice(product.getProductPrice());
			productDTO.setQuantity(product.getQuantity());

			productDTOs.add(productDTO);
		}

		return productDTOs;

	}

	public List<ProductDTO> getProductByCustomer(int customerId)
	{
		CustomerEntity customer = customerRepository.findById(customerId).get();
        

        Cart cart = customer.getCart();
        
        
        List<Product> products=cart.getProducts();
        List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
        
        for(Product product:products)
        {
        	ProductDTO productDTO=new ProductDTO();
        	
        	
        	productDTO.setBrand(product.getBrand());
        	productDTO.setCategory(product.getCategory());
        	productDTO.setProductId(product.getProductId());
        	productDTO.setProductImage(product.getProductImage());
        	productDTO.setProductName(product.getProductName());
        	productDTO.setProductPrice(product.getProductPrice());
        	productDTO.setQuantity(product.getQuantity());
        	
        	productDTOs.add(productDTO);
        	
        }

        return productDTOs;
	}

}
