package com.xai.oopTest2.phases;

import java.util.Scanner;

import com.xai.oopTest2.Phase;
import com.xai.oopTest2.Service;
import com.xai.oopTest2.User;

public class PhaseOver implements IPhase {
	
	public PhaseOver(){
		
	}
	
	@Override
	public void execute(){
		System.out.println("PhaseOver");
		
		setNextPhase(new PhaseStart());
	}

	@Override
	public void setNextPhase(IPhase phase) {
		Service.setPhase(phase);
		
	}
	
}
