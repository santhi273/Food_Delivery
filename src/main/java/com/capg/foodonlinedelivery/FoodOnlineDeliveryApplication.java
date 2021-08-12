package com.capg.foodonlinedelivery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FoodOnlineDeliveryApplication {
	public static Logger logger;
	public static void main(String[] args) {
		SpringApplication.run(FoodOnlineDeliveryApplication.class, args);
		logger = LoggerFactory.getLogger(FoodOnlineDeliveryApplication.class);
		
		boolean isDebugEnable =	logger.isDebugEnabled();
		
		logger.info("Is Debug Enable "+isDebugEnable);
		
	}
}
