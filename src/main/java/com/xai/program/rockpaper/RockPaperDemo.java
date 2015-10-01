package com.xai.program.rockpaper;

import java.util.Random;
import java.util.Scanner;

import com.xai.program.rockpaper.Hand.TYPE;

public class RockPaperDemo {

	public static void main(String [] args){
		
		Player p1 = new Player("P1", new Hand(TYPE.Paper));
		Player p2 = new Player("P2", new Hand(TYPE.Rock));
		
		/*
		Scanner sc = new Scanner(System.in);
		
		//letting input choose
		//player 1
		System.out.println("P1 choice: 1=rock 2=paper 3=sisscor");
		String p1handType = sc.nextLine();
		
		if(p1handType.toLowerCase().equals("1")){
			p1.getHand().setType(TYPE.Rock);
		}else if(p1handType.toLowerCase().equals("2")){
			p1.getHand().setType(TYPE.Paper);
		}else if(p1handType.toLowerCase().equals("3")){
			p1.getHand().setType(TYPE.Sisscor);
		}
		
		//player 2
		System.out.println("P2 choice: 1=rock 2=paper 3=sisscor");
		String p2handType = sc.nextLine();
		
		if(p2handType.toLowerCase().equals("1")){
			p2.getHand().setType(TYPE.Rock);
		}else if(p1handType.toLowerCase().equals("2")){
			p2.getHand().setType(TYPE.Paper);
		}else if(p1handType.toLowerCase().equals("3")){
			p2.getHand().setType(TYPE.Sisscor);
		}
		*/
		
		//random choose
		/////////////////////////////////////////////
		Random rand = new Random();
		int randomed = rand.nextInt(3);
		
		//p1
		if(randomed == 0){
			p1.getHand().setType(TYPE.Rock);
		}else if(randomed == 1){
			p1.getHand().setType(TYPE.Paper);
		}else if(randomed == 2){
			p1.getHand().setType(TYPE.Sisscor);
		}
		
		//p2
		randomed = rand.nextInt(3);
		if(randomed == 0){
			p2.getHand().setType(TYPE.Rock);
		}else if(randomed == 1){
			p2.getHand().setType(TYPE.Paper);
		}else if(randomed == 2){
			p2.getHand().setType(TYPE.Sisscor);
		}
		
		//conclusion
		System.out.println(p1 + " had " + p1.getHand());
		System.out.println(p2 + " had " + p2.getHand());
		System.out.println("Outcome is : " + new Match(p1,p2));
		
	}
	

	
}
