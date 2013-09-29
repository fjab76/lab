package fjab.concurrency;

import static org.apache.log4j.Logger.getLogger;

import java.util.Random;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

public class ThreadLab_Semaphore {

	private static Logger logger = getLogger(ThreadLab_Semaphore.class);
	
	public static void main(String[] args) {
				
		final SemaphoreInterface task = new ThreadLab_Semaphore().new OldSemphaforeImpl();
		try {
			task.process();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	interface SemaphoreInterface{
		
		public void process() throws InterruptedException;
		public void getItem() throws InterruptedException;
		public void returnItem() throws InterruptedException;
	}
	
	private class NewSemphaforeImpl implements SemaphoreInterface{
		
		private Logger logger = getLogger(getClass());
		
		private final static int SEMAPHORE_SIZE=10;
		private Semaphore semaphore = new Semaphore(SEMAPHORE_SIZE);
		
		public void process() throws InterruptedException{						
			
			new Thread(new Runnable(){
				
				public void run() {
					try {					
						getItem();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
			
			new Thread(new Runnable(){
				
				public void run() {
					try {					
						returnItem();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
			
			
		}
		
		public void getItem() throws InterruptedException{
			
			while(true){
				Thread.sleep(1000);
				semaphore.acquire();
				logger.info("num permits:"+semaphore.availablePermits());
			}
		}
		
		public void returnItem() throws InterruptedException{
			
			Random random = new Random();
			
			while(true){
				Thread.sleep(1000);
				
				if(random.nextInt(2)==0){
					semaphore.release();
					logger.info("num permits:"+semaphore.availablePermits());
				}
			}
		}
	}
	
	
	
	private class OldSemphaforeImpl implements SemaphoreInterface{
		
		private Logger logger = getLogger(getClass());
		
		private final static int SEMAPHORE_SIZE=10;
		private int currentNumPermits=SEMAPHORE_SIZE;
		
		public void process() throws InterruptedException{						
			
			new Thread(new Runnable(){
				
				public void run() {
					try {					
						getItem();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
			
			new Thread(new Runnable(){
				
				public void run() {
					try {					
						returnItem();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
			
			
		}
		
		public void getItem() throws InterruptedException{
			
			while(true){
				Thread.sleep(1000);
				
				synchronized(this){
					while(currentNumPermits==0){
						wait();
					}
					
					currentNumPermits--;
					logger.info("num permits:"+currentNumPermits);
					notify();
				}
			}
		}
		
		public void returnItem() throws InterruptedException{
			
			Random random = new Random();
			
			while(true){
				Thread.sleep(1000);
				
				if(random.nextInt(2)==0){
					
					synchronized(this){
						while(currentNumPermits==SEMAPHORE_SIZE){
							wait();
						}
						currentNumPermits++;
						logger.info("num permits:"+currentNumPermits);
						notify();
					}
				}
			}
		}
	}

}
