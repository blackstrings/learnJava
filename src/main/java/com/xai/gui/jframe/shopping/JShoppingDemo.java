package com.xai.gui.jframe.shopping;

import java.io.IOException;

public class JShoppingDemo {

	public static void main(String [] args) throws IOException{
		
		//test data for one item
		/*
		ClothingItem cat = new ClothingItem("5233", "Vase", 5.99);
		cat.setSize("9");
		System.out.println(cat);
		*/
		
		//create the store
		Store store = new Store();
		//tell store to load in items from file
		store.loadItems("res/files/testData.txt");
		
		//create customer
		Customer cust = new Customer();
		
		//the gui needs to be able to communicate with the store and customer
		ShoppingFrame frame = new ShoppingFrame(store, cust);
		frame.setVisible(true);
		
		//create the gui for user
		/*
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				ShoppingFrame frame = new ShoppingFrame();
				frame.setVisible(true);
			}

		});
		*/
	}
	
}
