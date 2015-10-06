package com.xai.program.shipment;

public class FedEx {

	//package data stored here
	private double weight;
	
	public FedEx(double weight){
		this.weight = weight;
	}
	
	public double shippingCharge(){
		System.out.println("calculating FedEx cost...");
		double price = 0.0;
		
		//round to nearest lbs
		double weightRounded = Math.round(weight);
		
		//first thing we can check
		//is to check if the rounded weight is over 150 lbs
		if( weightRounded > 150.0){
			// if box weighs over 150 lbs limit, it's over our application's requirement
			// so just return 0, no need to do anything further
			return 0; 					
		}
		System.out.println("weight is under 150 lbs");
		
		//check if weight is a small number like 0.23 LBS, if so round it 1 instead of zero
		if(weightRounded <= 0){	//any weight less than 1LBS is rounded to 1LBS
			weightRounded = 1.0;		//force the weight to 1 rather than 0
		}else{
			weightRounded = Math.round(weight);	//we will get a 1.0 or higher
		}
		System.out.println("rounded weight is: " + weightRounded);
		
		//pass the weightRounded into remainingWeight
		//for to begin the subtraction process
		double remainingWeight = weightRounded;
		
		//we subtract 1.0 from weight until we have no more 1LBS weight to subtract
		//or we reach 0 or negative
		//first subtraction adds $6.6 while each subtraction there after will add .20 per 1LBS
		if(remainingWeight >= 1.0){
			price += 6.6;	//charge $6.6 for the first lbs
			remainingWeight -= 1.0;
			
			//for every 1 LBS remaning, we add .20 charge fee
			while(remainingWeight >= 1.0){
				price += .20;
				remainingWeight -= 1.0;
			}
			
		}else{
			//the box is less than 1 lbs, 
			//which means it is automatically rounded to 1 lbs
			//which 1bs cost 6.6
			price = 6.6;
		}
		
		//per one package, there is a surchage fee
		final double surCharge = 3.10;
		
		price += surCharge;// add surCharge onto current price
		
		return price;
	}
	
}
