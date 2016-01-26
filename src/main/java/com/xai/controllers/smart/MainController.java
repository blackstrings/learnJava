package com.xai.controllers.smart;

public class MainController {

	AIBaseController target;
	
	public MainController(AIBaseController target){
		this.target = target;
	}
	
	public void replaceTarget(AIBaseController target){
		this.target = target;
	}
	
	public void keyA(){
		target.keyA();
	}
	
	public void keyB(){
		target.keyB();
	}
	
	
}
