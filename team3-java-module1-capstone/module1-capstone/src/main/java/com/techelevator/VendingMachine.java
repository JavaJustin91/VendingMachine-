package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

	private BigDecimal currentBalance = new BigDecimal(0);
	private Map<String, List<Item>> inventory;
	String changeList;
	Change makeChange;
	Log log;
	
	public VendingMachine() throws FileNotFoundException {
		CSVFileImport importer = new CSVFileImport();
		inventory = importer.importedCSV();
		makeChange = new Change();
		log = new Log();

	}

	public BigDecimal feedMoney(String money) throws IOException {

		BigDecimal moneyPaid = new BigDecimal(money);

		currentBalance = currentBalance.add(moneyPaid);
		String balance = currentBalance.toString();
		String message = "FEED MONEY: " + "$" + money + "\t" + "$" + balance;
		log.logAudit(message);

		return currentBalance;

	}

	public String getBalance() {
		String balance = currentBalance.toString();
		return balance;
	}

	public void selectProduct(String selection) throws IOException {
		if (!inventory.containsKey(selection)) { // If the key is not valid
			System.out.println("Invalid Selection");
		} else if (inventory.get(selection).size() == 0) { // If out of stock
			System.out.println("Out of Stock");
		} else {
			Item item = inventory.get(selection).get(0);
			String balance = currentBalance.toString();
			if (currentBalance.subtract(item.getProductPrice()).signum() >= 0) {
				currentBalance = currentBalance.subtract(item.getProductPrice());
				item = inventory.get(selection).remove(0);
				System.out.println(item.getSound());
				String finalBalance = currentBalance.toString();
				String message = item.getProductName() + " " + selection + " $" + balance + "\t" + "$" + finalBalance;
				log.logAudit(message);

			} else {
				System.out.println("Insufficient Funds");
			}

		}
	}

	public String finishTransaction() throws IOException {
		String balance = currentBalance.toString();

		String change = makeChange.change(currentBalance);

		currentBalance = BigDecimal.ZERO;
		String finalBalance = currentBalance.toString();
		String message = "GIVE CHANGE : " + "$" + balance + "\t" + "$" + finalBalance;
		log.logAudit(message);
		return change;
	}

	public String mapToString() {
		String output = new String("");
		for (String key : inventory.keySet()) {
			output += key + " ";
			List<Item> items = inventory.get(key);
			if (items.isEmpty()) {
				output += " - This item is empty.\n";

			} else {
				for (Item iteMs : items) {
					output += " - " + iteMs.getProductName();
					output += ": $" + iteMs.getProductPrice();
				}
				output += "\n";
			}
		}
		return output;
	}

}
