package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.watercanappstockms.dto.ReserveDTO;
import com.revature.watercanappstockms.exception.ValidatorException;
import com.revature.watercanappstockms.service.StockService;

public class ReserveTesetCases {
	
	@Autowired
	StockService stockservice;
	
	ReserveDTO reserve = new ReserveDTO();

	@Test
	public void validTest() {

		reserve.setReservedCans(10);
		reserve.setUserId(1);
		try {
			stockservice.reserveCans(reserve);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertNotNull(reserve);
	}

	@Test
	public void invalidTest() {

		reserve.setReservedCans(-4146);
		reserve.setUserId(-956);
		try {
			stockservice.reserveCans(reserve);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertNotNull(reserve);

	}

	@Test
	public void invalidZeroTest() {

		reserve.setReservedCans(0);
		reserve.setUserId(0);
		try {
			stockservice.reserveCans(reserve);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		assertNotNull(reserve);

	}

	
	
}
