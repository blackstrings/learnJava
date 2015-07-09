package com.xai.patterns.state2.state;

public class StateFactory {

	public static IState get(State state){
		
		switch (state) {
		case START:
			return new StartState();
		case PROCESS:
			return new ProcessState();
		case END:
			return new EndState();
		default:
			return new StartState();
		}
	}
}
