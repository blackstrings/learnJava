package com.xai.program.store;

import com.xai.program.store.domain.GasStation;
import com.xai.program.store.domain.Item;
import com.xai.program.store.domain.Product;
import com.xai.program.store.domain.Store;

public class StoreDemo {

	public static void main(String [] args){
		
		Store gas = new GasStation(101, 0.0);
		Product product = new Item("Cola", 1.50);
		gas.sell(product);
		
	}
}
