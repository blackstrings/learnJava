package com.xai.ddd;

import com.xai.ddd.currency.Baht;
import com.xai.ddd.currency.CurrencyFactory;
import com.xai.ddd.currency.Dollar;
import com.xai.ddd.dao.BankDaoImpl;
import com.xai.ddd.domain.Bank;
import com.xai.ddd.domain.Country;
import com.xai.ddd.service.ApplicationService;

/**
 * for more info http://www.informit.com/articles/article.aspx?p=1944876&seqNum=2
 * @author xlao
 *
 */
public class DomainDrivenDesignDemo {

	public static void main(String [] arg){
		
		//1 - semantic way - bad way
		//---------------------------------------------------------------
		printNL(1);
		int balance = 100;
		balance -= 50;
		System.out.println(balance);
		
		//2 - non semantic - a little bit better way
		//-------------------------------------------------------------
		printNL(2);
		Bank bank = new Bank(new Dollar(5));
		bank.deposit(new Dollar(-3.0));
		
		System.out.println("thai : " + bank.getBalanceConvertTo(Country.THAILAND));
		System.out.println("us : " + bank.getBalanceConvertTo(Country.USA) );
		System.out.println("euro : " + bank.getBalanceConvertTo(Country.EUROPE) );
		System.out.println("yuan : " + bank.getBalanceConvertTo(Country.CHINESE));
		
		System.out.println();
		
		Bank bank2 = new Bank(new Baht(32.48));
		System.out.println("us : " + bank2.getBalanceConvertTo(Country.USA));
		System.out.println("euro : " + bank2.getBalanceConvertTo(Country.EUROPE));
		System.out.println("yuan : " + bank2.getBalanceConvertTo(Country.CHINESE));
		System.out.println();
		
		//3 - even better way is to use the application service call to do the adding
		//---------------------------------------------------------------------
		printNL(3);
		ApplicationService as = new ApplicationService();
		BankDaoImpl br = as.getBankRepo();
		
		// add a bank -- this should be handle within applicaiton service but for demo we have it here
		long bankId1 = 1001L;
		long bankId2 = 1002L;
		br.add(new Bank(bankId1));
		br.add(new Bank(bankId2));
		
		//moving towards ddd, we can add fundings like this
		br.getBankById(bankId1).deposit(new Baht(32.5));
		br.getBankById(bankId2).deposit(new Dollar(32.5));
		
		//even better way is you should not need to know the currency class when adding
		//the country type should suffice
		//though one bank has currencyTypeA, the same bank can add another currency type
		//auto conversion will take place behind the scene
		br.getBankById(bankId1).deposit(CurrencyFactory.getCurrency(Country.USA,20));
		
		Bank bank1 = br.getBankById(bankId1);
		//get the balance
		System.out.println(Country.EUROPE.getType()
				+ " : " + bank1.getBalanceConvertTo(Country.EUROPE));
		
		System.out.println(Country.USA.getType()
				+ " : " + bank1.getBalanceConvertTo(Country.USA));
		
		System.out.println(br.getBankById(bankId1).getCurrencyType() 
				+ " : " + bank1.getBalance());
		
		//4 - Moving closer to perfect DDD way is this way
		//--------------------------------------------------------------------------
		printNL(4);
		long bankId3 = 1003L;		//system will generate a new customer and id
		br.add(new Bank(bankId3));	//a new bank id will be created and map to customer
		//now we let the application service handle bank transactions
		ApplicationService.deposit(bankId3, CurrencyFactory.getCurrency(Country.USA, 1));
		ApplicationService.deposit(bankId3, CurrencyFactory.getCurrency(Country.THAILAND, 32.0));
		printBalance(bankId3, br);
		
		
		//5 - keeps getting better
		//----------------------------------------------------------------------------
		printNL(5);
		long bankId4 = 1004L;
		br.add(new Bank(bankId4));
		ApplicationService.deposit(bankId4, Country.USA, 1d);
		ApplicationService.deposit(bankId4, Country.THAILAND, 32.0);
		printBalance(bankId4, br);
		printBalance(bankId4, br, Country.THAILAND);
		printBalance(bankId4, br, Country.EUROPE);
	}
	
	private static void printNL(int num){
		System.out.println("\n-- " + num + " --------------------------------------------------");
	}
	private static void printBalance(long bankId, BankDaoImpl br){
		System.out.println(br.getBankById(bankId).getCurrencyType() 
				+ " : " + ApplicationService.getBalance(bankId));
	}
	private static void printBalance(long bankId, BankDaoImpl br, Country toCountry){
		System.out.println(toCountry.getType()
				+ " : " + ApplicationService.getBalance(bankId, toCountry));
	}
	
}
