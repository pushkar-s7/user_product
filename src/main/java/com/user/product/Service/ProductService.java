package com.user.product.Service;

import java.util.List;

import com.user.product.Entities.Product;

public interface ProductService {
	
  public List<Product> getAllProduct();
  public List<Product> getProductByCategory(String category);
  public Product addProduct(Product product);
  public Product updateProduct(Long id,Product product);
  public Product getProductById(Long id);
  public Product inactiveProduct(Long productId);
}
