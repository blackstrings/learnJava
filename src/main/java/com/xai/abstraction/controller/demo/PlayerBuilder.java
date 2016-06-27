package com.xai.abstraction.controller.demo;

public class PlayerBuilder {
	public static PlayerBase get(PlayerType playerType){
		if(playerType == PlayerType.HUMAN){
			return getHumanPlayer();
		}
		
		return new HumanPlayer();
	}
	
	private static PlayerBase getHumanPlayer(){
		PlayerBase p = new HumanPlayer();
		PlayerAnimController c = new PlayerAnimController();
		c.addBehavior(new Run());
		p.setPlayerAnimController(c);
		return p;
	}
}
