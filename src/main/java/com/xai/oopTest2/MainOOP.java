package com.xai.oopTest2;

import com.xai.oopTest2.phases.PhaseBegin;
import com.xai.oopTest2.phases.PhaseKeepGoing;
import com.xai.oopTest2.phases.PhaseStart;

public class MainOOP {

	public static void main(String [] args){
	
		Service.init();
		Service.setPhase(new PhaseStart());
		
		//loop
		do{
			Service.getPhase().execute();
		} while (!Service.isOver());
		
	}
	
	private static void phaseOver(){
		System.out.println("PhaseOver");
	}
	
}
