package com.user.product.Reposistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.product.Entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{
  List<Product> findByCategory(String category);
}
