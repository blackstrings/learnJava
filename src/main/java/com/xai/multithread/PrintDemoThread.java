package com.xai.multithread;

public class PrintDemoThread extends Thread {

	private Thread t;
	private String threadName;
	PrintDemo pd;
	
	public PrintDemoThread(String name, PrintDemo pd){
		threadName = name;
		this.pd = pd;
	}
	
	public void run(){
		synchronized(pd){
			pd.printCount();
		}
		//when the above is complete, this thread will end
		System.out.println("Thread " + threadName + " exiting.");
	}
	
	public void start(){
		System.out.println("Starting " + threadName);
		
		if(t == null){
			t = new Thread (this, threadName);
			t.start();
		}
	}
	
}
