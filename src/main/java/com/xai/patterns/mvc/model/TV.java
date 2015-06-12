package com.xai.patterns.mvc.model;

public class TV {
	
	private int channel;
	private String brand;
	
	public TV(String brand){
		this.brand = brand;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
	
}
