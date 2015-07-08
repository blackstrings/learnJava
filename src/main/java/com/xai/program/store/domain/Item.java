package com.xai.program.store.domain;

public class Item implements Product {

	private String name;
	private double price;
	
	public Item(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

}
