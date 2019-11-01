package com.revature.watercanappstockms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ReserveOrder {

	int availcans = 1000;
	int validreservecans = 500;
	int validordercans = 500;
	
	@Test
	public void validtest() {

		assertEquals(validreservecans,validordercans);
		assertTrue(availcans>validordercans);
	
	}
	
	@Test
	public void invalidtest() {

		assertFalse(validreservecans<validordercans);
		assertFalse(availcans<validordercans);
		assertNotEquals(validordercans,0);
		assertNotEquals(validordercans,-1);
	
	}

}
