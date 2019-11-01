package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.watercanappstockms.exception.ValidatorException;
import com.revature.watercanappstockms.validator.LoginValidation;

public class UserTestCases {
	
	Long number =7799779977l;
	Long inum = 77997799l;
	String pwd ="S*guna1997";

	@Test
	public void validTest() throws ValidatorException {
		
		LoginValidation lv = new LoginValidation();
		boolean msg;
		msg = lv.validateMobileNo(number);
		
		assertTrue(msg);
		assertEquals("S*guna1997",pwd);
		assertNotNull(msg);
		assertNotNull(pwd);
	}
	
	@Test
	public void invalidTest() throws ValidatorException {
		
		LoginValidation lv = new LoginValidation();
		boolean msg;
		msg = lv.validateMobileNo(number);
		
		assertFalse(msg);
		assertNotEquals("S*GUNA1997",pwd);
	
	}

	
	@Test
	public void invalidNumberTest() throws ValidatorException {
		
		LoginValidation lv = new LoginValidation();
		boolean msg;
		msg = lv.validateMobileNo(number);
		
		assertFalse(msg);
		assertEquals("S*guna1997",pwd);
	}

	
	@Test
	public void invalidPwdTest() throws ValidatorException {
		
		LoginValidation lv = new LoginValidation();
		boolean msg;
		msg = lv.validateMobileNo(number);
		
		assertTrue(msg);
		assertNotEquals("S*GUNA1997",pwd);
	}

}
