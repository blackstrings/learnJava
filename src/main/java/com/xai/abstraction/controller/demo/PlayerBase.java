package com.xai.abstraction.controller.demo;

/**
 * In abstraction all player should have to call is run, and not worry about
 * how to make the run work, let the anim controlle handle this
 */
public abstract class PlayerBase {
	
	protected PlayerAnimController playerAnimController;
	public PlayerAnimController getPlayerAnimController() { return playerAnimController;}
	public void setPlayerAnimController(PlayerAnimController playerAnimController) { this.playerAnimController = playerAnimController;}

	public void run(){
		if(playerAnimController != null){
			playerAnimController.run();
		}
	};
	
	
	
}
