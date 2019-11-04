package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.watercanappstockms.dto.OrderDTO;
import com.revature.watercanappstockms.exception.ValidatorException;
import com.revature.watercanappstockms.service.StockService;

@SpringBootTest
public class OrderTesetCases {

	@Autowired
	StockService stockservice;

	@Test
	public void validTest() {

		OrderDTO order = new OrderDTO();
		order.setId(1);
		order.setOrderCans(10);
		order.setUserId(1);
		try {
			stockservice.orderCans(order);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertNotNull(order);
	}

	@Test
	public void invalidTest() {

		OrderDTO order = new OrderDTO();
		order.setId(-464);
		order.setOrderCans(-4146);
		order.setUserId(-956);
		try {
			stockservice.orderCans(order);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertNotNull(order);

	}

	@Test
	public void invalidZeroTest() {

		OrderDTO order = new OrderDTO();
		order.setId(0);
		order.setOrderCans(0);
		order.setUserId(0);
		try {
			stockservice.orderCans(order);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertNotNull(order);

	}

}
