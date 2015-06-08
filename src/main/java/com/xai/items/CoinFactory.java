package com.xai.items;

import java.util.ArrayList;
import java.util.List;

public class CoinFactory {

	public CoinFactory(){}
	
	public List<Item> getCoins(int bCount, int sCount, int gCount){
		List<Item> coinList = new ArrayList<Item>();
		BronzeCoin bCoin = new BronzeCoin(bCount);
		SilverCoin sCoin = new SilverCoin(sCount);
		GoldCoin gCoin = new GoldCoin(gCount);
		
		coinList.add(bCoin);
		coinList.add(sCoin);
		coinList.add(gCoin);
		
		return coinList;
	}
	
	public List<Item> getCoins(){
		return getCoins(0,0,0);
	}
}
