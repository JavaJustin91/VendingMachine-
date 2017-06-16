package com.techelevator;


import java.math.BigDecimal;

public class Change {
	
	
	
	public String change(BigDecimal totalChange){
		BigDecimal quarter = new BigDecimal(".25");
		BigDecimal dime = new BigDecimal(".10");
		BigDecimal nickel = new BigDecimal(".05");
		int numberOfQuarters = 0;
		int numberOfDimes = 0 ;
		int numberOfNickels = 0;
		while(totalChange.subtract(quarter).signum()>=0){
			totalChange = totalChange.subtract(quarter);
			numberOfQuarters += 1;
		}
		while(totalChange.subtract(dime).signum()>=0){
			totalChange = totalChange.subtract(dime);
			numberOfDimes += 1;
		}
		while(totalChange.subtract(nickel).signum()>=0){
			totalChange = totalChange.subtract(nickel);
			numberOfNickels += 1;
		}
		return numberOfQuarters + " Quarters " + numberOfDimes + " Dimes " + numberOfNickels + " Nickels ";
	} 
	

}
