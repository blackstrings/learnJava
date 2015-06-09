package com.xai.oopTest2;

import com.xai.oopTest2.phases.PhaseBegin;
import com.xai.oopTest2.phases.PhaseKeepGoing;

public class MainOOP {

	public static void main(String [] args){
	
		Service.init();
		Service.setPhase(Phase.BEGIN);
		
		do{
			//better approach would be to turn phases into command
			//IPhase phase.execute();
			//Service.getCurrPhase().execute();
			switch (Service.getPhase()) {
			case BEGIN:
				new PhaseBegin();
				break;
			case KEEPGOING:
				new PhaseKeepGoing();
				break;
			default:
				Service.setPhase(Phase.OVER);
				break;
			}
		} while (Service.getPhase() != Phase.OVER);
		
		phaseOver();
		
	}
	

	private static void phaseOver(){
		System.out.println("PhaseOver");
	}
	
}
