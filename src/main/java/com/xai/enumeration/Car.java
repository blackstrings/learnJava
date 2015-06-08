package com.xai.enumeration;

public enum Car {

	//if you want associate more properties to the enum value, you must create the constructor
	VAN(50000.00, "Red"),
	TRUCK(60000.00, "Green"),
	SEMI(22000.00, "Black");
	
	public double cost;
	public  String color;
	
	Car(double cost, String color){
		this.cost = cost;
		this.color = color;
	}
	
	//you can get the enum value by doing something like 
	//Car.VAN.cost;
	//Car.TRUCK.color;
}
