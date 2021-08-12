package com.capg.foodonlinedelivery.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IdNotFoundException extends Exception{
	Logger logger = LoggerFactory.getLogger(IdNotFoundException.class);
public  IdNotFoundException(String msg) {
	super(msg);
	logger.error(msg);
}
}
