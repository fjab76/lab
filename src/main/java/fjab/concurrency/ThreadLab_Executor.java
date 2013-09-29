package fjab.concurrency;

import static org.apache.log4j.Logger.getLogger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/*
 * Thread pools
 */
public class ThreadLab_Executor {
		
	private static Logger logger = getLogger(ThreadLab_Executor.class);
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int numThreads=4;
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		
		int numTasks=5;
		for(int j=0;j<numTasks;j++){
			executor.submit(new Task(j));			
		}
		
		executor.shutdown();
		
		logger.info("All tasks submitted");
		
		boolean tasksCompleted=false;
		try {
			tasksCompleted=executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(tasksCompleted){
			long stopTime = System.currentTimeMillis();
			logger.info("All tasks completed,time taken:"+(stopTime-startTime));
		}
		else{
			logger.info("No all tasks completed");
		}

	}

}


class Task extends Thread{
	
	private Logger logger = getLogger(getClass());
	
	private int id;
	
	Task(int id){
		this.id=id;
	}
	
	@Override
	public void run(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("Task="+id+" completed by thread="+Thread.currentThread().getName());
	}
}
