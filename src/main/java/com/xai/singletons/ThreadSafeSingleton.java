package com.xai.singletons;

/**
 * Singletons is a state class in which there can only be one instance at any given time throughout the app.
 * most of the scenarios, Singleton classes are created for resources such as File System, 
 * Database connections etc and we should avoid the instantiation until unless client calls the getInstance method
 *
 */

/**
 * Example of a thread safe singleton. When you have multiple thread, there is the possibility of more than
 * one instance being created at the same time. Using synchronized, we only allow one thread at any given time to
 * access this getInstance. Upon access, the object is locked until the thread inside the object leaves.
 * more about singletons here 
 * http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples#thread-safe-singleton
 *
 */
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;
	
	private ThreadSafeSingleton(){}
	
	public static synchronized ThreadSafeSingleton getInstance(){
		if(instance == null){
			instance = new ThreadSafeSingleton();
		}
		
		return instance;
	}
	
}
