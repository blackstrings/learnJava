package com.xai.oopTest2.phases;

import java.util.Scanner;

import com.xai.oopTest2.Phase;
import com.xai.oopTest2.Service;

public class PhaseBegin {
	
	public PhaseBegin(){
		System.out.println("PhaseBegin");
		System.out.println("How many users?");
		
		Scanner sc = new Scanner(System.in);
		String numOfUsersTmp = sc.nextLine();
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
		
		Service.setPhase(Phase.KEEPGOING);
	}
	
}
