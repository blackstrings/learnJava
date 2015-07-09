package com.xai.patterns.state2.state;

import java.util.Scanner;

public class ProcessState implements IState {

	private IState nextState;
	
	@Override
	public void execute() {
		System.out.println("Process State");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your age");
		String age = sc.nextLine();
		
		nextState = StateFactory.get(State.END);
	}

	@Override
	public IState nextState() {
		return nextState;
	}

}
