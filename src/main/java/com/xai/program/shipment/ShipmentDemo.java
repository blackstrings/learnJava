package com.xai.program.shipment;

import java.util.Scanner;

public class ShipmentDemo {

	public static void main(String [] args){
		
		//test data
		double width = 1.5;
		double length = 2.5;
		double height = 2.3;
		double weight = 152.0;
		
		//get keyboard inputs
		//---------------------------------------------
		
		Scanner scan = new Scanner(System.in);	
		
		System.out.println("Please enter your package data\n");
		System.out.println("Enter Width:");
		width = scan.nextDouble();
		
		System.out.println("Enter length:");
		length = scan.nextDouble();
		
		System.out.println("Enter height:");
		height = scan.nextDouble();
		
		System.out.println("Enter Weight:");
		weight = scan.nextDouble();
		
		//End of keyboard inputs
		
		//run calculations
		//---------------------------------------------------------
		
		//create the objects
		UPS boxUPS = new UPS(width, length, height, weight);
		FedEx boxFedEx = new FedEx(weight);
		
		System.out.println("----------------------------------------");
		double fedExCost = boxFedEx.shippingCharge();
		System.out.println("----------------------------------------");
		double upsCost = boxUPS.shippingCharge();
		System.out.println("----------------------------------------");
		
		if(fedExCost == 0 || upsCost == 0){
			System.out.println("Shipping weight is over 150 lbs -- too large to ship for this application");
		}else{
			if( upsCost < fedExCost){
				//use ups for the cheapest
				System.out.println("UPS is cheaper: $" + upsCost);
				System.out.println("FedEx is : $" + fedExCost);
			}else{
				//use fedEx for the cheapest
				System.out.println("FedEx is cheaper: $" + fedExCost);
				System.out.println("UPS is: $" + upsCost);
			}
		}
		
		
	}
	
}
