package com.xai.program.travel;

import java.util.List;
import java.util.Random;

public class RemoveTravelerEvent extends TravelEvent {

	private String[] randomMsg;
	
	public RemoveTravelerEvent(User user){
		super(user);
		
		randomMsg = new String[]{
				"Burned",
				"Disappear",
				"Zapped",
				"Sucide",
				"Choked"
		};
	}
	
	@Override
	public void action() {
		if(user.getTravelerSize() > 0){
			Random rand = new Random();
			int randomIndex = rand.nextInt(user.getTravelerSize());
			
			String randMsg = getRandomMsg(rand);
			if(isTravelerLucky(randomIndex)){
				System.out.println(user.getTravelerNameAt(randomIndex) + " escaped being " + randMsg);
			}else{
				System.out.println(randMsg);
				System.out.println("lost: " + user.getTravelerNameAt(randomIndex));
				user.removeTravelerAt(randomIndex);
			}
		}
		
	}
	
	private String getRandomMsg(Random rand){
		return randomMsg[rand.nextInt(randomMsg.length)];
	}
	
	private boolean isTravelerLucky(int randIndex){
		int l = user.getTravelerAt(randIndex).getStats().l;
		Random rand = new Random();
		double randD = rand.nextDouble();
		if(randD > l*.1){
			return false;
		}
		return true;
	}

}
