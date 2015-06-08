package com.xai.multithread;

/**
 * Each thread will run at their own pace. You can join and wait threads and stuff. you can set priority too.
 * @author xlao
 *
 */
public class MultiThreadDemo {

	public static void main(String [] args){
		
		//example 1
		//runBasicThreadExample1();
		
		//example 2 - with synchronization
		//runSynchronizeExample1();
		
		//wait for all thread to complete
		waitForAllThreadToCompleteExample1();
		
	}
	
	//all threads will run independently of each other
	private static void runBasicThreadExample1(){
		//one way to create a thread - ThreadThree implements runnable
		Runnable thread3 = new ThreadThree("thread3");
		Thread t3 = new Thread(thread3);
		t3.start();
		
		//one way to create a thread - ThreadOne extends Thread with default constructor
		Thread t1 = new Thread(new ThreadOne(), "thread1");
		t1.start();
		
		//another way to create a thread
		Thread t2 = new ThreadTwo("thread2");
		t2.setDaemon(true);
		t2.setName("threadTwo");
		t2.start();
		
		try{
			t1.join();
			t2.join();
			t3.join();
		}catch(InterruptedException  e){
			System.out.println("interrupted");
		}
	}
	
	//for synchronize to work, the obj (printDemo) has to be set to synchronized inside the thread
	// that is running the printDemo, see printDemoThread
	private static void runSynchronizeExample1(){
		boolean allThreadComplete = false;
		
		PrintDemo pd = new PrintDemo();
		Thread t1 = new PrintDemoThread("t1", pd);
		Thread t2 = new PrintDemoThread("t2", pd);
		
		t1.start();
		t2.start();
		
	}
	
	//using join to wait for one or more thread to finish before the next thread can begin
	/**
	 * Waiting for specific threads or a set amount of threads to complete can be tricky and complex. 
	 * A listener or the concurrent
	 * package should be used for complex thread waiting.
	 * This example demonstrates demonstrates the join method to wait for threads.
	 * Only useful for very simple thread waiting.
	 */
	private static void waitForAllThreadToCompleteExample1(){
	
		Thread t1 = new ThreadTwo("t1");
		Thread t2 = new ThreadTwo("t2");
		Thread t3 = new ThreadTwo("t3");
		Thread t4 = new ThreadTwo("t4");
		
		t1.start();
		
		//pause here and don't start t2 && t3 until t1 completes
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		t3.start();
		
		//pause here and don't start t4 until t2 and t3 completes
		try {
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t4.start();
		
		//pause here and don't complete the main thread until all thread are executed
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All threads done executing");
		
	}

}
