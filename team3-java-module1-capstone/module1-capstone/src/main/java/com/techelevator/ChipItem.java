package com.techelevator;

public class ChipItem extends Item {

	@Override
	public String getSound() {
		String chipSound = new String();
		chipSound = "Crunch Crunch, Yum!";
		return chipSound;
	}
}
