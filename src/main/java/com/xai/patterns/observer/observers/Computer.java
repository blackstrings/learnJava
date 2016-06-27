package com.xai.patterns.observer.observers;

import com.xai.patterns.observer.Observer;
import com.xai.patterns.observer.SubjectImpl;

public class Computer extends Observer {
	private String name;
	
	public Computer(SubjectImpl subject, String name){
		this.subject = subject;
		this.name = name;
		subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println("Computer " + name + " is being updated");
	}

}
