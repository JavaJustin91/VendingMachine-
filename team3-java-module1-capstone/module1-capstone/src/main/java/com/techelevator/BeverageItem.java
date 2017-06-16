package com.techelevator;

public class BeverageItem extends Item {

	@Override
	public String getSound() {
		String bevSound = new String();
		bevSound = "Glug Glug, Yum!";
		return bevSound;
	}
}
