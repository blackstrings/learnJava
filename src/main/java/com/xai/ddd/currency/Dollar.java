package com.xai.ddd.currency;

import com.xai.ddd.Country;


public class Dollar extends Currency {
	
	public Dollar(double amt) {
		setAmount(amt);
		setCountry(Country.USA);
		
	}
	
	
}
