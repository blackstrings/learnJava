package com.xai.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	private int num;
	
	public SubjectImpl(){
		
	}
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void dettach(Observer observer){
		int index = observers.indexOf(observer);
		if(index >= 0){
			observers.remove(index);
		}
	}
	
	public void setNewNumber(int num){
		this.num = num;
		notifyAllObservers();
	}
	
	//notifies all observers connected to this subject
	public void notifyAllObservers(){
		for(Observer observer : observers){
			observer.update();
		}
	}

}
