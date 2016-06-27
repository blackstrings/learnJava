package com.xai.abstraction.controller.demo;

public class PlayerFactory {
	public static PlayerBase getPlayer(PlayerType playerType){
		return PlayerBuilder.get(playerType);
	}
}
