package com.xai.controllers.smart;

public class ControllerDemo {

	public static void main(String[] args){
		
		//test
		MainController ctrl = new MainController(new CharacterB());
		ctrl.keyA();
		ctrl.keyB();
		
		ctrl.replaceTarget(new CharacterA());
		ctrl.keyA();
		ctrl.keyB();
		
	}
}
