package com.xai.program.travel;

import java.util.Scanner;

public class TravelDemo {

	public static void main(String[] args){
		
		User user = new User(100);
		TravelerFactory tfac = new TravelerFactory();
		user.add(tfac.getRandomTravelers(10));
		
		EnvFactory envFac = new EnvFactory();
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		int day = 0;
		
		do{
			
			TravelUtils.setEnvs(day, user, envFac);
			
			System.out.println("cont?");
			input = sc.nextLine();
			EventFactory.applyRandomEvent(user).action();
			day++;
		}while(!user.isTravelerEmpty() && input.startsWith("l"));
		
		System.out.println("done");
		
		
	}
	
}
