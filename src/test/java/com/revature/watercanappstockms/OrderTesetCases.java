package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrderTesetCases {

	int availcans = 1000;
	int validordercans = 500;
	
	@Test
	public void validTest() {
	
		assertTrue(availcans>validordercans);
	}
	
	@Test
	public void invalidTest() {
	
		assertFalse(availcans<validordercans);
		assertNotEquals(validordercans,0);
		assertNotEquals(validordercans,-1);
		
		
	}

}
