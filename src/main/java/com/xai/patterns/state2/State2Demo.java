package com.xai.patterns.state2;

import com.xai.patterns.state2.state.EndState;
import com.xai.patterns.state2.state.IState;
import com.xai.patterns.state2.state.State;
import com.xai.patterns.state2.state.StateFactory;

public class State2Demo {

	public static void main(String [] args){
		
		IState currState = StateFactory.get(State.START);
		
		do{
			currState.execute();
			currState = currState.nextState();
		}while(!(currState instanceof EndState));
		
		System.out.println("end of program");
		
	}
}
