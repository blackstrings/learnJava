package com.xai.patterns.state.phase;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.xai.patterns.state.Phase;
import com.xai.patterns.state.Service;
import com.xai.patterns.state.User;

public class PhaseBegin implements IPhase {
	
	public PhaseBegin(){
		
	}
	
	@Override
	public void execute(){
		System.out.println("PhaseBegin");
		System.out.println("How many users? 4 Max");
		
		Scanner sc = new Scanner(System.in);
		
		String numOfUsersTmp;
		
		
		numOfUsersTmp = sc.nextLine();
		while(numOfUsersTmp.isEmpty() || !NumberUtils.isNumber(numOfUsersTmp)){
			
			System.out.println("Enter a Number between 0-5");
			numOfUsersTmp = sc.nextLine();
			
		}
		//due to nextInt consuming the new blank line
		//keep the scanner to the same input type
		
		int numOfUsers = Integer.parseInt(numOfUsersTmp);
		int count = 0;
		do{
			System.out.println("Enter username " + count);
			String username = sc.nextLine();
			if(username != null){
				Service.addUser(username + count);
				count++;
			}
			
		}while(count < numOfUsers);
		
		for(User user : Service.getStateManager().getUsers()){
			System.out.println(user.getName());
		}
		
		setNextPhase(new PhaseKeepGoing());
	}

	@Override
	public void setNextPhase(IPhase phase) {
		Service.setPhase(phase);
		
	}
	
}
