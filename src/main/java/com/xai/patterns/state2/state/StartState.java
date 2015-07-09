package com.xai.patterns.state2.state;

import java.util.Scanner;

public class StartState implements IState {

	private IState nextState;
	
	@Override
	public void execute() {
		System.out.println("Start State");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your name");
		String name = sc.nextLine();
		
		nextState = StateFactory.get(State.PROCESS);
	}

	@Override
	public IState nextState() {
		return nextState;
	}

}
