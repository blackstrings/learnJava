package com.xai.oopTest2;

import java.util.Scanner;

import com.xai.oopTest2.phases.PhaseBegin;

public class MainOOP {

	public static void main(String [] args){
		/*
		User u = new User("user1");
		Model m1 = new Model();
		Service.addWepToModel(new Wep(3), m1 );
		Service.addWepToModel(new Wep(4), m1 );
		Service.addModelToUser(m1, u);
		
		Model m2 = new Model();
		Service.addWepToModel(new Wep(3), m2);
		Service.addModelToUser(m2, u);
		
		System.out.println(Service.getOutFromUser(u));
		*/
		
		Service.init();
		Service.setPhase(Phase.BEGIN);
		
		do{
			switch (Service.getPhase()) {
			case BEGIN:
				new PhaseBegin();
				break;
			case KEEPGOING:
				phaseKeepGoing();
				break;
			default:
				Service.setPhase(Phase.OVER);
				break;
			}
		} while (Service.getPhase() != Phase.OVER);
		
		phaseOver();
		
	}
	
	
	private static void phaseKeepGoing(){
		System.out.println("PhaseKeepGoing");
		Service.setPhase(Phase.OVER);
	}
	
	private static void phaseOver(){
		System.out.println("PhaseOver");
	}
	
}
