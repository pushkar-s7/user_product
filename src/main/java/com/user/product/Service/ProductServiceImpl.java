package com.user.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.product.Entities.Product;
import com.user.product.Exception.ProductNotFoundException;
import com.user.product.Exception.ProductUpdateException;
import com.user.product.Reposistory.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productrepo;
	
	
	@Override
	public List<Product> getAllProduct() {
		List<Product> productList=productrepo.findAll();
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("No products Found.");
		}
		return productList;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> productList=productrepo.findByCategory(category);
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("No products Found for category:"+category);
		}
		return productList;
	}

	@Override
	public Product addProduct(Product product) {
		try {
		   return productrepo.save(product);
		} catch (Exception e) {
			throw new RuntimeException("Failed to add product.");
	  }
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		 Product existingProduct = productrepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
		
		    existingProduct.setName(product.getName());
	        existingProduct.setCategory(product.getCategory());
	        existingProduct.setBrand(product.getBrand());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setAvailability(product.getAvailability());
	 
	        try {
	             return productrepo.save(existingProduct);
	        } catch (Exception e) {
	            throw new ProductUpdateException("Failed to update product with id: " + id);
	      }
	}

	@Override
	public Product getProductById(Long id) {
		return productrepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
	}

	@Override
	public Product inactiveProduct(Long productId) {
		  Product product = productrepo.findById(productId)
	                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
	 
	        product.setAvailability(0);
	 
	        try {
	           return productrepo.save(product);
	        } catch (Exception e) {
	            throw new ProductUpdateException("Failed to update availability for product with id: " + productId);
	        }
	}

}
