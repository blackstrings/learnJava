package com.xai.multithread;

/**
 * Note that this class extends the thread class
 * @author xlao
 *
 */
public class ThreadOne extends Thread {
	
	//must override this run method
	@Override
	public void run(){
		
		for(int i=0; i<5; i++){
			System.out.println(this.getName() + " still running");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
