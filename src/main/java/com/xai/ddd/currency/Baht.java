package com.xai.ddd.currency;

import com.xai.ddd.Country;

public class Baht extends Currency {

	public Baht(double amt) {
		setAmount(amt);
		setCountry(Country.THAILAND);
	}

	
}
