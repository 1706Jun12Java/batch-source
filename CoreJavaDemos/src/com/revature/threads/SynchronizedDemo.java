package com.revature.threads;

public class SynchronizedDemo {

	public static void main(String[] args) {
		// create and start two threads, which call an increment() method 500 times
		
		Count c = new Count();
		Runnable job = new TestRunnable(c);
		
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
		t1.start();
		t2.start();
		
		//wait for threads to finish
		try{
			t1.join();
			t2.join();
		} catch (InterruptedException e){
			e.printStackTrace();
			e.getMessage();
		}
		
		System.out.println("Count: "+c.count);
	}

}

class Count {
	int count;
	public synchronized void increment() {
		count = count +1;
	}
}

//Runnable that calls increment() 500 times 
class TestRunnable implements Runnable {

	Count c;
	
	public TestRunnable(Count c){
		this.c = c;
	}
	
	@Override
	public void run() {
		for (int i = 0;i<5000;i++){
			c.increment();
			//System.out.println(c.count);
		}
		
	}
	
}