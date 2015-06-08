package com.xai.ddd;

import org.apache.log4j.Logger;

import com.xai.ddd.currency.ICurrency;

public class Bank {
	
	final static Logger logger = Logger.getLogger(Bank.class); 
	
	Long id = null;
	ICurrency currency;
	
	public Bank(long id){
		this.id = id;
	}
	
	public Bank(){
		
	}
	public Bank(ICurrency currency){
		this.currency = currency;
	}
	
	public void setCurrency(ICurrency currency){
		this.currency = currency;
	}
	
	public ICurrency getCurrency(){
		return currency;
	}
	
	public String getCurrencyType(){
		if(currency != null){
			return currency.getCountry().getType();
		}
		logger.warn("No currency is set for this bank");
		return null;
	}
	
	public void deposit(ICurrency currency){
		if(this.currency != null){
			//same currency
			if(this.currency.getCountry() == currency.getCountry()){
				this.currency.addAmount( currency.getAmount() );
			}else{ //different currency being deposited
				
				logger.warn("Adding a different currency type, conversion will take place");
				//need to do conversion then add onto existing balance
				double convertedAmount = getCurrencyConvertedTo(currency, this.currency.getCountry());
				this.currency.addAmount( convertedAmount );
			}
		}else{
			this.currency = currency;
		}
	}
	
	public double getBalance(){
		return currency.getAmount();
	}
	
	public double getCurrencyConvertedTo(ICurrency currency, Country toCountry){
		return new CurrencyConverter().convert(currency, toCountry);
	}
	
	public double getBalanceConvertTo(Country toCountry){
		if(currency != null){
			return new CurrencyConverter().convert(currency, toCountry);
		}else{
			logger.warn("no currency exist");
			return 0;
		}
	}
	
	public long getId(){
		return id;
	}
}
