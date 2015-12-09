package com.xai.gui.jframe.shopping;

import javax.swing.JOptionPane;

public class Customer {

	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	//max size indicated by instructions
	private int maxSize = 5;
	//holds the items that the custom will buy
	public CatalogItem[] shoppingCart = new CatalogItem[maxSize];	
	
	private int numItemsOrdered = 0;

	public Customer(){
		// n/a stands for not avaialbe, the customer will have to create an account
		// in order to fill in thse fields at runtime
		//shoppingFrame will call customer's method: enterCustomerInfo
		//at checkout or account creation at runtime
		this.name = "n/a";
		this.address = "n/a";
		this.city = "n/a";
		this.state = "n/a";
		this.zip = "n/a";
	
	}
	
	public void addToShoppingCart(CatalogItem item){
		
		//remember we can only add up to 5 items due to max size set at 5
		if(numItemsOrdered <= 4){
			//first item order will be at index 0
			shoppingCart[numItemsOrdered] = item;
			
			//provide a counter
			//this will help use keep track of how many items we have in our shopping cart
			//next time we add an item, numItemsOrdered will know which index to start at
			numItemsOrdered++;
			System.out.println("Adding Item to customer cart: " 
					+ numItemsOrdered + " / " + maxSize);
		}else{
			System.out.println("Customer cannot add anymore items to cart. Item not added.");
		}
	}
	
	//a prompt window will occur and ask user to enter the customer's personal information
	public void enterCustomerInfo(){
		name = JOptionPane.showInputDialog(null, "Enter Customer Name");
		address = JOptionPane.showInputDialog(null, "Enter Customer address");
		city = JOptionPane.showInputDialog(null, "Enter Customer city");
		state = JOptionPane.showInputDialog(null, "Enter Customer state");
		zip = JOptionPane.showInputDialog(null, "Enter Customer zip");
	}
	
	// ------------------------- 
	// Getters and Setters
	// -------------------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getNumItemsOrdered() {
		return numItemsOrdered;
	}

	public void setNumItemsOrdered(int numItemsOrdered) {
		this.numItemsOrdered = numItemsOrdered;
	}
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<numItemsOrdered; i++){
			sb.append(shoppingCart[i]);
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
