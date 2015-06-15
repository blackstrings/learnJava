package com.xai.patterns.mvc.model;

/**
 * model only holds data with getters and setter methods, 
 * no logic should be put in here, such as if this and else that
 *
 */
public class TVModel {
	
	//the data this model holds
	private int channel;
	private String brand;
	
	//constructor
	public TVModel(String brand){
		this.brand = brand;
	}

	//getters and setters
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public String getBrand(){
		return brand;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	
}
