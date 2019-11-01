package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ReserveTesetCases {
	
	int availcans = 1000;
	int validreservecans = 500;
	
	@Test
	public void validTest() {
	
		assertTrue(availcans>validreservecans);
	}
	
	@Test
	public void invalidTest() {
	
		assertFalse(availcans<validreservecans);
		assertNotEquals(validreservecans,0);
		assertNotEquals(validreservecans,-1);
		
		
	}
}
