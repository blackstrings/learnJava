package com.xai.patterns.decorator.demo.component;

public class Eye implements Feature {
	
	@Override
	public void action(){
		System.out.println("Is Looking");
	}
}
