package com.xai.patterns.observer.observers;

import com.xai.patterns.observer.Observer;
import com.xai.patterns.observer.SubjectImpl;

public class Browser extends Observer {
	private String name;
	
	public Browser(SubjectImpl subject, String name){
		this.name = name;
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println("The browser " + name + " is now being updated");

	}

}
