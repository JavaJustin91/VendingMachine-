package com.techelevator.view;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import com.techelevator.VendingMachine;

public class VendingMachineTest {
	
	VendingMachine sut;
	
	@Before
	public void setUp() throws Exception {
	    sut = new VendingMachine();

	}

	@Test
	public void testFeedMoney() throws IOException {
		
		BigDecimal newB = new BigDecimal(1);
		
		assertEquals(newB, sut.feedMoney("1"));
		
	}

	@Test
	public void testBuyingAllItemsMakesItemEmpty() throws IOException {
		sut.feedMoney("10");
		sut.feedMoney("10");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		sut.selectProduct("A1");
		
		
		assertTrue("There should be no more A1", sut.mapToString().contains("A1  - This item is empty."));
		
	}
	
	@Test
	public void testNoMoneyNoItem() throws IOException {
		assertTrue("Items should all be there at start", sut.mapToString().contains("A1  - Potato Crisps: $3.05 - Potato Crisps: $3.05 - Potato Crisps: $3.05 - Potato Crisps: $3.05 - Potato Crisps: $3.05"));
		sut.selectProduct("A1");
		
		assertTrue("Items should still all be there", sut.mapToString().contains("A1  - Potato Crisps: $3.05 - Potato Crisps: $3.05 - Potato Crisps: $3.05 - Potato Crisps: $3.05 - Potato Crisps: $3.05"));
		
	}

	@Test
	public void testFinishTransaction() throws IOException {
		
		String money = new String("10");
		
		sut.feedMoney(money);
		
		assertEquals("40 Quarters 0 Dimes 0 Nickels " , sut.finishTransaction());


		
	}

}
