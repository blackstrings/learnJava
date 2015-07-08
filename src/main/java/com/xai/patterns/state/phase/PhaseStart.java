package com.xai.patterns.state.phase;

import java.util.Random;
import java.util.Scanner;

import com.xai.patterns.state.Model;
import com.xai.patterns.state.Phase;
import com.xai.patterns.state.Service;
import com.xai.patterns.state.User;
import com.xai.patterns.state.Wep;

public class PhaseStart implements IPhase{

	public PhaseStart(){
		
	}
	
	@Override
	public void execute(){
		System.out.println("PhaseStart");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Q to quite or any key enter to continue");
		String input = sc.nextLine();
		
		if(input.equals("q")){
			System.out.println("System exiting");
			System.exit(0);
		}else{
			setNextPhase(new PhaseBegin());
		}
	}

	@Override
	public void setNextPhase(IPhase phase) {
		Service.setPhase(phase);
	}
}
