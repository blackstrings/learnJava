package com.xai.multithread;

/**
 * Note that this class extends the thread class
 * @author xlao
 *
 */
public class ThreadTwo extends Thread {
	
	private String name;
	
	public ThreadTwo(String name){
		this.name = name;
	}
	
	//must override this run method
	@Override
	public void run(){
		
		for(int i=0; i<5; i++){
			System.out.println(name + " still running");
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(name + " complete");
		
	}
	
	
}
