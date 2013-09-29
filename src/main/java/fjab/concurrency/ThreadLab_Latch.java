package fjab.concurrency;

import static org.apache.log4j.Logger.getLogger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/*
 * Latches
 */
public class ThreadLab_Latch {
		
	private static Logger logger = getLogger(ThreadLab_Latch.class);
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int numThreads=4;
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		
		int numTasks=5;
		CountDownLatch latch = new CountDownLatch(numTasks);
		for(int j=0;j<numTasks;j++){
			executor.submit(new Task1(j,latch));			
		}
		
		executor.shutdown();
		
		logger.info("All tasks submitted");
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		long stopTime = System.currentTimeMillis();
		logger.info("All tasks completed,time taken:"+(stopTime-startTime));
		

	}

}


class Task1 extends Thread{
	
	private Logger logger = getLogger(getClass());
	
	private int id;
	private CountDownLatch latch;
	
	Task1(int id, CountDownLatch latch){
		this.id=id;
		this.latch=latch;
	}
	
	@Override
	public void run(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		
		logger.info("Task="+id+" completed by thread="+Thread.currentThread().getName());
	}
}
