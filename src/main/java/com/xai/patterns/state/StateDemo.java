package com.xai.patterns.state;

import com.xai.patterns.state.phase.PhaseBegin;
import com.xai.patterns.state.phase.PhaseKeepGoing;
import com.xai.patterns.state.phase.PhaseStart;

public class StateDemo {

	public static void main(String [] args){
		
		//init the starting settings
		Service.init();
		
		//set the first phase
		Service.setPhase(new PhaseStart());
		
		//loop through all phases and keep looping till the last phase is reached
		do{
			Service.getPhase().execute();
		} while (!Service.isOver());
		
	}
	
	private static void phaseOver(){
		System.out.println("PhaseOver");
	}
	
}
