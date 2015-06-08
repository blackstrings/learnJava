package com.xai.ddd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.HashMap;

import com.xai.ddd.currency.Dollar;
import com.xai.ddd.currency.ICurrency;

public class CurrencyConverter {

	private Map<String, Float> exchageRateMap = new HashMap<String, Float>();
	
	public CurrencyConverter(){
		exchageRateMap.put(Country.USA.name(), 1.0f);
		exchageRateMap.put(Country.THAILAND.name(), 32.482560f);
		exchageRateMap.put(Country.EUROPE.name(), 0.925170f);
		exchageRateMap.put(Country.CHINESE.name(), 6.195546f);
	}
	
	public double convert(ICurrency currency){
		return convert(currency, currency.getCountry());
	}
	
	public double convert(ICurrency currency, Country toCountry){
		
		//if returning the same currency, no conversion needed
		if(currency.getCountry().name().equals( toCountry.name() )){
			return currency.getAmount();
		}else{
	
			/**
			 * The following setup is based off of the US dollar
			 */
			float exchangeRate = 0;
			
			//usa to another currency
			if(currency.getCountry().name().equals(Country.USA.name()) && !toCountry.name().equals(Country.USA.name()) 
					&& !currency.getCountry().name().equals(Country.USA) ){
				exchangeRate = exchageRateMap.get( toCountry.name() ) 
						/ exchageRateMap.get( Country.USA.name() );
			
			//another currency to usa
			}else if (toCountry.name().equals(Country.USA.name())){
				exchangeRate = exchageRateMap.get( Country.USA.name() ) 
						/ exchageRateMap.get( currency.getCountry().name() ) ;
			
			}else{//another currency to another currency
				
				///convert to usa then to the other currency
				exchangeRate = exchageRateMap.get( Country.USA.name() ) 
						/ exchageRateMap.get( currency.getCountry().name() ) ;
				double tempVal = currency.getAmount() * exchangeRate;
				return convert(new Dollar(round(tempVal, 2)), toCountry);
				
			}
			
			double val = currency.getAmount() * exchangeRate;
			return round(val, 2);
			
		}
	}
	
	private double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/*
	private int conversion(ICurrency currency){
		double exchangeRate = (Double)map.get("baht") / (Double)map.get("dollar");
		double val = currency.getAmount() * exchangeRate;
		return ((Double)val).intValue();
	}
	*/
	
}
