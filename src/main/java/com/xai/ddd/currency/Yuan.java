package com.xai.ddd.currency;

import com.xai.ddd.Country;

public class Yuan extends Currency {

	public Yuan(double amt) {
		setAmount(amt);
		setCountry(Country.CHINESE);
	}

	
}
