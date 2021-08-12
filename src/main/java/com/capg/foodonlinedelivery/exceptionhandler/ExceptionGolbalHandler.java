package com.capg.foodonlinedelivery.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ExceptionGolbalHandler {
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ErrorDetails> invalidNameException(String message,HttpServletRequest request) { 
		ErrorDetails error=new ErrorDetails();
			error.setMessage(message);
			error.setUrl(request.getRequestURL().toString());
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidItemNameException.class)
	public ResponseEntity<ErrorDetails> invalidItemNameException(String message,HttpServletRequest request) { 
		ErrorDetails error=new ErrorDetails();
			error.setMessage(message);
			error.setUrl(request.getRequestURL().toString());
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDetails> idNotFoundException(String message,HttpServletRequest request) { 
		ErrorDetails error=new ErrorDetails();
			error.setMessage(message);
			error.setUrl(request.getRequestURL().toString());
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DistinctRestaurantException.class)
	public ResponseEntity<ErrorDetails> distinctRestaurantException(String message,HttpServletRequest request) { 
		ErrorDetails error=new ErrorDetails();
			error.setMessage(message);
			error.setUrl(request.getRequestURL().toString());
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RemoveFailedException.class)
	public ResponseEntity<ErrorDetails> removeFailedException(String message,HttpServletRequest request) { 
		ErrorDetails error=new ErrorDetails();
			error.setMessage(message);
			error.setUrl(request.getRequestURL().toString());
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
}
