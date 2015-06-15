package com.xai.ddd.currency;

import java.util.HashMap;
import java.util.Map;

import com.xai.ddd.domain.Country;

public class CurrencyFactory {

	private static Map<String, Currency> countryMap;
	
	
	public static Currency getCurrency(Country country, double amount){

		countryMap = new HashMap<String, Currency>();
		/* TODO find a better way to do this
		for(Country name:Country.values()){
			countryMap.put(Country.USA, new Dollar(0));
		}
		*/
		countryMap.put(Country.USA.name(), new Dollar(0));
		countryMap.put(Country.THAILAND.name(), new Baht(0));
		countryMap.put(Country.EUROPE.name(), new Euro(0));
		countryMap.put(Country.CHINESE.name(), new Yuan(0));
		
		//if(countryMap.containsValue(country.name())){
			Currency currency =  countryMap.get(country.name());
			currency.addAmount(amount);
			return currency;
		//}
		//return null;
	}
	
}
