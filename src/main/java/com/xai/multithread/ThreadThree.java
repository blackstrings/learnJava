package com.xai.multithread;

/**
 * Note that this class extends the thread class
 * @author xlao
 *
 */
public class ThreadThree implements Runnable {
	
	private String name;
	
	public ThreadThree(String name){
		this.name = name;
	}
	
	//must override this run method
	@Override
	public void run(){
		int i = 0;
		while(i < 5){
			System.out.println(name + " still running");
			
			//if you sleep a thread you have to enclose it with try catch
			//as it will throw interuptedExcpetion
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i++;
		}
		
	}
	
	
}
