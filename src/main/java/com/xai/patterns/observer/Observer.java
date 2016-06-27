package com.xai.patterns.observer;

public abstract class Observer {
	protected SubjectImpl subject;
	public abstract void update();
	
}
