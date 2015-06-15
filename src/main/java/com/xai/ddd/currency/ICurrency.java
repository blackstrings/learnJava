package com.xai.ddd.currency;

import com.xai.ddd.domain.Country;

public interface ICurrency {
	public void setAmount(double amount);
	public double getAmount();
	public void addAmount(double amt);
	public Country getCountry();
	public String getAmountToString();
}
