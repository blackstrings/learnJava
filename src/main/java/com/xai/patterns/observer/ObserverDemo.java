package com.xai.patterns.observer;

import com.xai.patterns.observer.observers.Browser;
import com.xai.patterns.observer.observers.Computer;

public class ObserverDemo {

	public static void main(String [] args){
		Subject sub = new Subject();
		
		//register the subject to each observer
		Browser b1 = new Browser(sub, "safari");
		Browser b2 = new Browser(sub, "firefox");
		
		Computer c1 = new Computer(sub, "mac");
		Computer c2 = new Computer(sub, "pc");
		
		//when as soon as subject changes state, 
		//all observers will be automatically notify with the observer pattern
		sub.setNewNumber(99);	//subject changes state to a new number
	}
}
