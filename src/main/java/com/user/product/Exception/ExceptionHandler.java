package com.user.product.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
		
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
      
    }
     
	  @org.springframework.web.bind.annotation.ExceptionHandler(ProductUpdateException.class)
	  public ResponseEntity<String> handleProductUpdateException(ProductUpdateException ex) {
		  
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	        
	    }
}
