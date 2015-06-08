package com.xai.gametest2.factory;

/**
 * The blueprints for each fish specie
 * @author xlao
 *
 */
public enum FishData {
	//eventualy, these hard code values can be removed and be loaded from a text file
	RAINBOW_TROUT("Rainbow Trout", 0.5, 4.0, 1.5), 
	WALLEYE("Walleye", 0.5, 5.0, 1.1), 
	STURGEON("Sturgeon", 0.5, 12.0, 2.0), 
	SMALL_MOUTH_BASS("Small Mouth Bass", 0.5, 3.0, 1.5);
	
	private String name;
	private double minSize;
	private double maxSize;
	private double lbsPerFoot;
	
	FishData(String name, double minSize, double maxSize, double lbsPerFoot){
		this.name = name;
		this.minSize = minSize;
		this.maxSize = maxSize;
		this.lbsPerFoot = lbsPerFoot;
	}
	
	//getters
	public String getName(){return name;}
	public double getMinSize(){return minSize;}
	public double getMaxSize(){return maxSize;}
	public double getLbsPerFoot(){return lbsPerFoot;}
	
	//setters - though enums are not meant to change, in this case we need it to chagne,
	// this will allow you to change the values at runtime
	public void setMaxSize(double newMaxSize){
		this.maxSize = newMaxSize;
	}
}
