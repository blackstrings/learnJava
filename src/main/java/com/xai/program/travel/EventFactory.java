package com.xai.program.travel;

import java.util.List;
import java.util.Random;

public class EventFactory {

	public static TravelEvent applyRandomEvent(User data){
		
		Random rand = new Random();
		
		int key = rand.nextInt(2);
		switch (key) {
		case 0:
			return new RemoveTravelerEvent(data);
		case 1:
			return new MerchantEvent(data);
		default:
			return new RemoveTravelerEvent(data);
		}
		
	}
	
}
