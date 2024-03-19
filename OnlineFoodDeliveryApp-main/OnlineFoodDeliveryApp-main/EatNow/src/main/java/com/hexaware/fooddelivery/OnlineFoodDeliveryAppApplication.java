package com.hexaware.fooddelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="karthik",
				version="3.2.0",
				description="for testing",
				contact=@Contact(
						name="M.karthik",
						email="karthikmedam10@gmail.com"),
				license=@License(name="Licence",
				url="http://karthikportfolio.ezyro.com/")
				)
		
		
		
		
		)
public class OnlineFoodDeliveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodDeliveryAppApplication.class, args);
	}

}
