package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.watercanappstockms.dto.StockDTO;
import com.revature.watercanappstockms.exception.ServiceException;
import com.revature.watercanappstockms.model.Stock;
import com.revature.watercanappstockms.service.StockService;

@SpringBootTest
public class AdminTestCases {

	@Autowired
	StockService stockservice;

	StockDTO stock = new StockDTO();

	@Test
	public void validTest() {

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

		stock.setUpdatecans(-100);
		String emessage = null;
		String message = "Please Enter Watercans greater than 0";
		try {
			stockservice.updateCans(stock);

		} catch (ServiceException e) {
			e.printStackTrace();
			emessage = e.getMessage();
		}
		assertEquals(emessage,message);
	}

	@Test
	public void invalidZeroTest() {

		stock.setUpdatecans(0);
		String emessage = null;
		String message = "Please Enter Watercans greater than 0";
		try {
			stockservice.updateCans(stock);

		} catch (ServiceException e) {
			e.printStackTrace();
			emessage = e.getMessage();
		}
		assertEquals(emessage,message);
	}

	@Test
	public void validListTest() {

		List<Stock> list = stockservice.viewStock();

		assertNotNull(list);

	}
}
