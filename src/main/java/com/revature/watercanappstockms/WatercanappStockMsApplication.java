package com.revature.watercanappstockms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WatercanappStockMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatercanappStockMsApplication.class, args);
	}
	
	@Bean
	public RestTemplate resttemplate()
	{
		return new RestTemplate();
	}
	

}
