package com.xai.patterns.state2.state;

public class EndState implements IState {

	private IState nextState;
	
	@Override
	public void execute() {
		//does nothing this state will trigger end of program
	}
	
	public IState nextState(){
		return null;
	}

}
