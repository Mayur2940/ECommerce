package com.Ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({AdminException.class})
	public ResponseEntity<String> handleAdminException(AdminException adminException){
		return new ResponseEntity<>(adminException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({CustomerException.class})
	public ResponseEntity<String> handleCustomerException(CustomerException customerException){
		return new ResponseEntity<>(customerException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ProductException.class})
	public ResponseEntity<String> handleProductException(ProductException productException){
		return new ResponseEntity<>(productException.getMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({CartException.class})
	public ResponseEntity<String> handleCartException(CartException cartException){
		return new ResponseEntity<>(cartException.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler({CategoryException.class})
	public ResponseEntity<String> handleCategoryException(CategoryException categoryException){
		return new ResponseEntity<>(categoryException.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler({OrderException.class})
	public ResponseEntity<String> handleOrderException(OrderException orderException){
		return new ResponseEntity<>(orderException.getMessage(),HttpStatus.NOT_FOUND);
	}

}
