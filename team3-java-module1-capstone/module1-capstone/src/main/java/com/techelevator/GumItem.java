package com.techelevator;


public class GumItem extends Item {

	@Override
	public String getSound() {
		String gumSound = new String();
		gumSound = "Chew Chew, Yum!";
		return gumSound;
	}

}
