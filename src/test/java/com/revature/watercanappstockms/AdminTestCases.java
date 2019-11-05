package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.watercanappstockms.dto.StockDTO;
import com.revature.watercanappstockms.exception.ServiceException;
import com.revature.watercanappstockms.service.StockService;


@SpringBootTest
public class AdminTestCases {
	
	@Autowired
	StockService stockservice;


	@Test
	public void validTest() {

		StockDTO stock = new StockDTO();
		stock.setUpdatecans(100);
		try {
			stockservice.updateCans(stock);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(stock);
	}

	@Test
	public void invalidTest() {
		
		StockDTO stock = new StockDTO();
		stock.setUpdatecans(-100);
		try {
			stockservice.updateCans(stock);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(stock);
	}
	
	@Test
	public void invalidZeroTest() {
		
		StockDTO stock = new StockDTO();
		stock.setUpdatecans(0);
		try {
			stockservice.updateCans(stock);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(stock);
	}
	
	
}
