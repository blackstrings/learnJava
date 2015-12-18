package com.xai.program.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TravelerFactory {

	int MAXPOINTS = 9;
	
	public TravelerFactory(){}
	
	public Traveler getRandomTraveler(){
		Traveler t = new Traveler();
		t.setStats(getRandomStats());
		return t;
	}
	
	public List<Traveler> getRandomTravelers(int total){
		List<Traveler> travelers = new ArrayList<Traveler>();
		for(int i=0; i<total; i++){
			Traveler t = getRandomTraveler();
			t.setName("traveler"+i);
			travelers.add(t);
		}
		return travelers;
	}
	
	private Stats getRandomStats(){
		Stats s = new Stats();
		Random rand = new Random();
		int key;
		
		for(int i=0; i<MAXPOINTS; i++){
			key = rand.nextInt(s.getTotalStats());
			switch (key) {
			case 0:
				s.l++;
				break;
			case 1:
				s.s++;
				break;
			case 2:
				s.i++;
				break;
			default:
				break;
			}
		}
		return s;
	}
}
