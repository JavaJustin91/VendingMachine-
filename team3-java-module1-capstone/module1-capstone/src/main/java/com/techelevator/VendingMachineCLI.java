package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;



import com.techelevator.view.Menu;

public  class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_BUY_ITEM = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTION = { PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_BUY_ITEM, PURCHASE_MENU_OPTION_FINISH };


	
	private VendingMachine vm;
	private Menu menu;
	String finish;
	String product;
	BigDecimal payment;

	public VendingMachineCLI(Menu menu, VendingMachine vm) throws FileNotFoundException {
		this.menu = menu;
		this.vm = vm;
		
		
	}
	
	public void run() throws IOException {
		
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(vm.mapToString());

			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					System.out.println("Current Balance " + "$" + vm.getBalance());

				String purchaseChoice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTION);
				if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH)) {
					
					String change = vm.finishTransaction();
					menu.setFinishTransaction(change);
					break;
				} else if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					String moneyAmount = menu.getFeedMoney();
					vm.feedMoney(moneyAmount);
				
				}
				else if(purchaseChoice.equals(PURCHASE_MENU_OPTION_BUY_ITEM)){
					String inventory = menu.getSelectProduct();
					vm.selectProduct(inventory);
					
				
				}
			
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, new VendingMachine());
		cli.run();
		
	}
	}

