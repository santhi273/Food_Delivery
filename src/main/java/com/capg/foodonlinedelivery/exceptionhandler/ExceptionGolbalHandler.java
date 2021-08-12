package com.capg.foodonlinedelivery.exceptionhandler;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ExceptionGolbalHandler extends ResponseEntityExceptionHandler{
	Logger logger = LoggerFactory.getLogger(ExceptionGolbalHandler.class);
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ErrorDetails> invalidNameException(InvalidNameException exception,WebRequest request) { 
		logger.error(exception.getMessage());
		ErrorDetails error=new ErrorDetails(exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidItemNameException.class)
	public ResponseEntity<ErrorDetails> invalidItemNameException(InvalidItemNameException exception,WebRequest request) { 
		
		ErrorDetails error=new ErrorDetails(exception.getMessage(), request.getDescription(false));
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDetails> idNotFoundException(IdNotFoundException exception,WebRequest request) { 
		ErrorDetails error=new ErrorDetails(exception.getMessage(), request.getDescription(false));
			
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DistinctRestaurantException.class)
	public ResponseEntity<ErrorDetails> distinctRestaurantException(DistinctRestaurantException exception, WebRequest request) { 
		ErrorDetails error=new ErrorDetails(exception.getMessage(), request.getDescription(false));
			
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}

	/*
	 * @ExceptionHandler(RemoveFailedException.class) public
	 * ResponseEntity<ErrorDetails> removeFailedException(String message) {
	 * ErrorDetails error=new ErrorDetails(); error.setMessage(message);
	 * //error.setUrl(request.getRequestURL().toString());
	 * 
	 * return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND); }
	 */
	@ExceptionHandler(RemoveFailedException.class)
	public ResponseEntity<ErrorDetails> removeFailedException(RemoveFailedException exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
}
