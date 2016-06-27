package com.xai.patterns.observer;

public interface Subject {
	public void attach(Observer o);
	public void dettach(Observer o);
}
