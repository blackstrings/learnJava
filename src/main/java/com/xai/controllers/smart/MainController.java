package com.xai.controllers.smart;

public class MainController {

	BasicHandHeldController target;
	
	public MainController(BasicHandHeldController target){
		this.target = target;
	}
	
	public void replaceTarget(BasicHandHeldController target){
		this.target = target;
	}
	
	public void keyA(){
		target.keyA();
	}
	
	public void keyB(){
		target.keyB();
	}
	
	
}
