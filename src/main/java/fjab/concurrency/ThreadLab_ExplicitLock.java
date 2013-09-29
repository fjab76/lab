package fjab.concurrency;

import static org.apache.log4j.Logger.getLogger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

/**
 * Using static lockers
 * @author fjab
 *
 */
public class ThreadLab_ExplicitLock {
	
	private static Logger logger = getLogger(ThreadLab_ExplicitLock.class);

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){

			public void run() {
				Task51 task = new Task51();
				for(int j=0;j<1000;j++){
					task.increaseCounter();
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			public void run() {
				Task51 task = new Task51();
				for(int j=0;j<1000;j++){
					task.increaseCounter();
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("counter="+CounterHolder.counter);
	}
	
	

}

class Task51{
	
	//private static  Object lock = new Object();
	private static Lock lock = new ReentrantLock();
	
	void increaseCounter(){
		/*synchronized(lock){
			CounterHolder.counter++;
		}*/
		try {
			lock.lock();
			CounterHolder.counter++;
		} 
		finally{
			lock.unlock();
		}
		
	}
}
