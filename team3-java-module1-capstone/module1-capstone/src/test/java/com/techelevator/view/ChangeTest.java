package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Change;

public class ChangeTest {
	
	Change sut;

	@Before
	public void setUp() throws Exception {
		
		sut = new Change();
	}

	@Test
	public void testChange() {
		
		BigDecimal change2 = new BigDecimal(1);
		
		assertEquals("4 Quarters 0 Dimes 0 Nickels ", sut.change(change2));
		
		
	}

}
