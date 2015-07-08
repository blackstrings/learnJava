package com.xai.patterns.state.phase;

import com.xai.patterns.state.Service;

public class PhaseOver implements IPhase {
	
	public PhaseOver(){
		
	}
	
	@Override
	public void execute(){
		System.out.println("PhaseOver");
		
		//reset everything
		Service.reset();
		
		setNextPhase(new PhaseStart());
	}

	@Override
	public void setNextPhase(IPhase phase) {
		Service.setPhase(phase);
		
	}
	
}
