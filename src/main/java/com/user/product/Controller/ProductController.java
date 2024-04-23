package com.user.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.product.Entities.Product;
import com.user.product.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
   @Autowired
   private ProductService productservice;
   
   
   @GetMapping
   public ResponseEntity<List<Product>> getAllProduct() {
       List<Product> product = productservice.getAllProduct();
       return ResponseEntity.ok(product);
   }
   @GetMapping("/category/{category}")
   public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
       List<Product> product = productservice.getProductByCategory(category);
       return ResponseEntity.ok(product);
   }
   @PostMapping
   public ResponseEntity<Product> addProduct(@RequestBody Product product) {
       Product product1 = productservice.addProduct(product);
       return ResponseEntity.status(HttpStatus.CREATED).body(product1);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
       Product updateProduct = productservice.updateProduct(id, product);
       return ResponseEntity.ok(updateProduct);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable Long id) {
       Product product = productservice.getProductById(id);
       return ResponseEntity.ok(product);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> inactivateProduct(@PathVariable Long id) {
       productservice.inactiveProduct(id);
       return ResponseEntity.noContent().build();
   }
   
}
