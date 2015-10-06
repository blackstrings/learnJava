package com.xai.program.shipment;

public class UPS {

	//package data stored here
	//width, lenght, and height are by inch, not by feet
	private double width;
	private double length;
	private double height;
	private double weight;
	
	public UPS(double width, double length, double height, double weight){
		this.width = width;
		this.length = length;
		this.height= height;
		this.weight = weight;
	}
	
	public double shippingCharge(){
		System.out.println("calculating UPS cost ...");
		double price = 0.0;
		
		//determine if we should use the actual weight rounded
		//or use the dimensional weight
		double remainingWeight = billableWeight();	//returns the weight to use
		
		//we subtract 1.0 from weight until we have no more 1LBS weight to subtract
		//or we reach 0 or negative
		//first subtraction adds $7 while each subtraction there after will add .25 per 1LBS
		if(remainingWeight >= 1.0){
			price += 7.0;	//charge $7 for the first lbs
			remainingWeight -= 1.0;
			
			//continue with price .25 per additional lbs, if there are still any left
			while(remainingWeight >= 1.0){
				price += .25;
				remainingWeight -= 1.0;
			}
			
		}else{
			//the box is less than 1 lbs, 
			//which means it is automatically rounded to 1 lbs
			//which 1bs cost 7.0
			price = 7.0;
		}
		
		return price;
	}
	
	//deterimine if actual rounded weight
	//or dimensional weight should be used
	//according to the assignemnt, use the one
	//with the higher number
	private double billableWeight(){
		
		double weightRounded = Math.round(weight);
		
		//first thing we can check
		//is to check if the rounded weight is over 150 lbs
		if( weightRounded > 150.0){
			// if box weighs over 150 lbs limit, it's over our application's requirement
			// so just return 0, no need to do anything further
			return 0; 					
		}
		
		//check if weight is a small number like 0.23 LBS, if so round it 1 instead of zero
		if(weightRounded <= 0){	//any weight less than 1LBS is rounded to 1LBS
			weightRounded = 1.0;		//force the weight to 1 rather than 0
		}else{
			weightRounded = Math.round(weight);	//we will get a 1.0 or higher
		}
		
		//use the formula from the assignment to find dimensional weight
		//but we must first round all 3 lengths to the nearest length
		double widthRounded = Math.round(width);
		if(widthRounded < 1.0){
			widthRounded = 1.0;	//to prevent zero
		}
		
		double lengthRounded = Math.round(length);
		if(lengthRounded < 1.0){
			lengthRounded = 1.0;
		}
		
		double heightRounded = Math.round(height);
		if(heightRounded < 1.0){
			heightRounded = 1.0;
		}
		
		double dimensionalWeight = (widthRounded * lengthRounded * heightRounded) / 166;
		System.out.println("dimensionalWeight: " + dimensionalWeight);
		System.out.println("weight:" + weightRounded);
		
		//use the higher number
		if(dimensionalWeight > weightRounded){
			//dimensionalWeight must be higher
			System.out.println("using dimension weight");
			return dimensionalWeight;
		}else{
			//weightRounded must be higher
			System.out.println("using actual rounded weight");
			return weightRounded;
		}
	}
	
}
