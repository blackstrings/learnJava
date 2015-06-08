package com.xai.ddd.currency;

import java.math.BigDecimal;

import com.xai.ddd.Country;

public abstract class Currency implements ICurrency {
	
	//private BigDecimal amount = BigDecimal.ZERO;
	private int base;
	double amount = 0;
	
	private Country country;
	
	public Currency(){
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public void addAmount(double amt){
		if(amount + amt <= 0){
			amount = 0.0;
		}else{
			amount += amt;
		}
	}
	
	public String getAmountToString(){
		return String.valueOf(amount);
	}
	
	public void setCountry(Country country){
		this.country = country;
	}
	
	public Country getCountry(){
		if(country != null){
			return country;
		}
		return null;
	}
	
	public void setBase(int amt){
		base = amt;
	}
	
	public int getBase(){
		return base;
	}
}
