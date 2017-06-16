package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CSVFileImport {
	
	public Map<String, List<Item>> importedCSV() throws FileNotFoundException {

		File csvFile = new File("vendingmachine.csv");
		Map<String, List<Item>> itemList = new TreeMap<>();
	
		try(Scanner reader = new Scanner(csvFile)) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				List<Item> items = new ArrayList<>();
	
				String[] itemInfo = line.split("\\|");
	
				for (int i = 0; i < 5; i++) {
					Item item;
					if (itemInfo[0].startsWith("A")) {
						item = new ChipItem();
					} else if (itemInfo[0].startsWith("B")) {
						item = new CandyItem();
					} else if (itemInfo[0].startsWith("C")) {
						item = new BeverageItem();
					} else {
						item = new GumItem();
	
					}
					item.setProductName(itemInfo[1]);
					item.setProductPrice(itemInfo[2]);
					items.add(item);
	
				}
				itemList.put(itemInfo[0], items);
			}	
		}
		return itemList;    
	}
	
}