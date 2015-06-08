package com.xai.ddd;

import org.apache.log4j.Logger;

import com.xai.ddd.currency.Currency;
import com.xai.ddd.currency.ICurrency;

/**
 * This is the application service.
 * @author xlao
 *
 */
public class ApplicationService {
	
	private static BankRepositoryImpl bankRepo;
	
	public ApplicationService(){
		bankRepo = new BankRepositoryImpl();
	}
	
	private static final Logger logger = Logger.getLogger(ApplicationService.class);
	
	private static double getCurrencyConvertedTo(ICurrency currency, Country toCountry){
		return new CurrencyConverter().convert(currency, toCountry);
	}
	
	public BankRepositoryImpl getBankRepo(){
		return bankRepo;
	}
	
	private static Bank getBank(long bankId){
		return bankRepo.getBankById(bankId);
	}
	
	/**
	 * better approach
	 * @param bankId
	 * @param country
	 * @param amount
	 */
	public static void deposit(long bankId, Country country, double amount){
		ICurrency currency = CurrencyFactory.getCurrency(country, amount);
		deposit(bankId, currency);
	}
	
	/**
	 * longer approach
	 * @param bankId
	 * @param currency
	 */
	public static void deposit(long bankId, ICurrency currency){
		Bank bank = getBank(bankId);
		ICurrency curr = bank.getCurrency();
		if(curr == null){//bank currency is not set
			logger.warn("Bank currency is not set. Defaulting bank's currency to " + currency.getCountry().name());
			bank.setCurrency(currency);
		}else if(bank.getCurrency().getCountry() == currency.getCountry()){
			curr.addAmount( currency.getAmount() );
		}else{ //different currency being deposited
			logger.warn("Adding a different currency type, conversion will take place");
			//need to do conversion then add onto existing balance
			double convertedAmount = getCurrencyConvertedTo(currency, curr.getCountry());
			curr.addAmount( convertedAmount );
		}
		/*
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
		}*/
	}
	
	public static double getBalance(long bankId){
		return getBank(bankId).getCurrency().getAmount();
	}
	public static double getBalance(long bankId, Country toCountry){
		return getBank(bankId).getBalanceConvertTo(toCountry);
	}
	
}
