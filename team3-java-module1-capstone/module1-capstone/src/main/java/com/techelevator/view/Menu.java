package com.techelevator.view;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.techelevator.Item;
import com.techelevator.VendingMachine;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) throws FileNotFoundException {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since
			// choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public String getFeedMoney() {
		String userInput = null;

		while (userInput == null) {
			out.println("Insert Money");
			out.flush();
			userInput = in.nextLine();

			if (!(userInput.equals("1") || userInput.equals("5") || userInput.equals("2") || userInput.equals("10"))) {

				out.println("Not a valid denomination");
				out.flush();
				userInput = null;
			}
		}
		return userInput;
	}
	public String getSelectProduct(){
		String inventory; 
		out.println("Make a Selection ");
		out.flush();
		inventory = in.nextLine();
		
		return inventory;
			
	}
	public void setFinishTransaction(String change){
		out.println("Your change is " + change);
		out.flush();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
