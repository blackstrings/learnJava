package com.xai.casting;

public class CastingDemo {

	public static void main(String [] args){
		
		//create and puts a truck inside a vehicle
		Vehicle v = new Truck();	//the real object is truck
		
		//cast the truck to its true form
		Truck t = (Truck) v;
		t.honk();	//now you can use truck methods
		
		//create a semi truck and put it in a truck object
		Truck semi = new SemiTruck();
		//semi.attachTrailer; //Error - Wrong - you cannot use semiTruck object
		//at least not in this form
		
		//cast the semiTruck into its true
		SemiTruck realSemiTruck = (SemiTruck) semi;
		realSemiTruck.attachTrailer();	//now you can see and use semi truck methods
		
	}
	
}
