package com.techelevator.view;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.CSVFileImport;

public class CSVTest {
	
	CSVFileImport sut;

	@Before
	public void setUp() throws Exception {
		
		sut = new CSVFileImport();
	}

	@Test
	public void testImportedCSV() throws FileNotFoundException {
		
		
		assertEquals( true ,sut.importedCSV().containsKey("A1"));

		
	}

}
