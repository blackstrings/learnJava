package com.xai.oopTest2.phases;

import java.util.Random;
import java.util.Scanner;

import com.xai.oopTest2.Model;
import com.xai.oopTest2.Phase;
import com.xai.oopTest2.Service;
import com.xai.oopTest2.User;
import com.xai.oopTest2.Wep;

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
