package com.xai.ddd.currency;

import com.xai.ddd.domain.Country;

public class Euro extends Currency {

	public Euro(double amt) {
		setAmount(amt);
		setCountry(Country.EUROPE);
	}

	
}
