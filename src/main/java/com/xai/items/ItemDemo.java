package com.xai.items;

import java.util.ArrayList;
import java.util.List;

import com.xai.items.Bag.BALANCETYPE;
import com.xai.items.Bag.PRINT;

public class ItemDemo {
	
	public static void main(String [] args){
		
		Bag bag = new Bag("Small Bag", 5, 20);
		System.out.println(bag.getName());
		
		bag.addItem(new GoldCoin(1));
		bag.addItem(new GoldCoin(2));
		bag.addItem(new GoldCoin(4));
		bag.addItem(new BronzeCoin(10));
		bag.addItem(new SilverCoin(1));
		
		bag.print(PRINT.TOTAL_BALANCE);
		bag.print(PRINT.ALL_COIN_COUNT);
		
		System.out.println( "Bronze Count: " + bag.getCoinBalanceByCoinType(BronzeCoin.class, BALANCETYPE.COUNT) );
		
		bag.emptyAllCoins();
		bag.print(PRINT.TOTAL_BALANCE);
		bag.print(PRINT.ALL_COIN_COUNT);
		
		bag.addItem(new Hammer("Black Hammer", 10,20, 8));
		bag.addItem(new Hammer("Small Hammer", 5,10, 6));
		bag.addItem(new Hammer("Red Hammer", 10,20, 7));
		
	}
	
}
