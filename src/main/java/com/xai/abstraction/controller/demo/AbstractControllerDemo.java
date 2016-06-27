package com.xai.abstraction.controller.demo;

public class AbstractControllerDemo {

	public static void main(String [] args){
		
		PlayerBase p1 = PlayerFactory.getPlayer(PlayerType.HUMAN);
		p1.run();
		
	}
	
}
