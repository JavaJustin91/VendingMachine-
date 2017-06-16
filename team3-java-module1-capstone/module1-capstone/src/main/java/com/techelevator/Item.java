package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class Item {

	BigDecimal productPrice;
	String productName;
	

	public void setProductPrice(String price) {

		productPrice = new BigDecimal(price);

	}

	public void setProductName(String productName) {
		
		this.productName = productName;

	}

	public BigDecimal getProductPrice() {

		return productPrice;
	}

	public String getProductName() {
		
		return productName;
		
		
	}
	public String  getSound(){
		return null;
	}

}
