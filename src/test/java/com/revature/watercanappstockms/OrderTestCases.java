package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.watercanappstockms.dto.OrderDTO;
import com.revature.watercanappstockms.exception.ServiceException;
import com.revature.watercanappstockms.exception.ValidatorException;
import com.revature.watercanappstockms.service.StockService;

@SpringBootTest
public class OrderTestCases {

	@Autowired
	StockService stockservice;

	@Test
	public void validTest() {

		OrderDTO order = new OrderDTO();
		order.setOrderCans(10);
		order.setUserId(1);
		try {
			stockservice.orderCans(order);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(order);
	}

	@Test
	public void invalidTest() {

		OrderDTO order = new OrderDTO();
		order.setOrderCans(-4146);
		order.setUserId(-956);
		String emessage = null;
		String message = "Unable to Order";
		try {
			stockservice.orderCans(order);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
			emessage = e.getMessage();
		}
		assertEquals(emessage,message);

	}

	@Test
	public void invalidZeroTest() {

		OrderDTO order = new OrderDTO();
		order.setOrderCans(0);
		order.setUserId(0);
		String emessage = null;
		String message = "Unable to Order";
		try {
			stockservice.orderCans(order);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
			emessage = e.getMessage();
		}
		assertEquals(emessage,message);


	}

}
