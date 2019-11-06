package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.watercanappstockms.dto.ReserveDTO;
import com.revature.watercanappstockms.exception.ServiceException;
import com.revature.watercanappstockms.exception.ValidatorException;
import com.revature.watercanappstockms.service.StockService;

@SpringBootTest
public class ReserveTestCases {

	@Autowired
	StockService stockservice;

	@Test
	public void validTest() {

		ReserveDTO reserve = new ReserveDTO();
		reserve.setReservedCans(10);
		reserve.setUserId(1);
		try {
			stockservice.reserveCans(reserve);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(reserve);
	}

	@Test
	public void invalidTest() {

		ReserveDTO reserve = new ReserveDTO();
		reserve.setReservedCans(-4146);
		reserve.setUserId(-956);
		String emessage = null;
		String message = "Unable to Reserve";
		try {
			stockservice.reserveCans(reserve);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
			emessage = e.getMessage();
		}
		assertEquals(emessage,message);

	}

	@Test
	public void invalidZeroTest() {

		ReserveDTO reserve = new ReserveDTO();
		reserve.setReservedCans(0);
		reserve.setUserId(0);
		String emessage = null;
		String message = "Unable to Reserve";
		try {
			stockservice.reserveCans(reserve);
		} catch (ValidatorException | ServiceException e) {
			e.printStackTrace();
			emessage = e.getMessage();
		}
		assertEquals(emessage,message);

	}

}
