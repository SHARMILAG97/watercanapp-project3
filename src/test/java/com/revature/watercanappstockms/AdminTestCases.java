package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class AdminTestCases {
	
	String name = "Naresh";
	String pwd = "naresh";

	@Test
	public void validTest() {

		assertEquals("Naresh",name);
		assertEquals("naresh",pwd);
		
	}

	@Test
	public void invalidTest() {
		
		assertNotEquals(name,"kjnhbghj54");
		assertNotEquals(pwd,"cdfgt87456");
		
	}
	
	@Test
	public void invalidNameTest() {
		
		assertNotEquals("NARESH",name);
		assertEquals("naresh",pwd);
		
	}
	
	@Test
	public void invalidPwdTest() {
		
		assertEquals("Naresh",name);
		assertNotEquals("NARESH",pwd);
		
	}
	
	@Test
	public void caseSensitiveNameTest() {
		
		assertNotEquals("NARESH",name);
		assertEquals("naresh",pwd);
		
	}
	
	@Test
	public void caseSensitivePwdTest() {
		
		assertEquals("Naresh",name);
		assertNotEquals("NARESH",pwd);
		
	}
	
}
