package fjab.concurrency;

import static org.apache.log4j.Logger.getLogger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

/**
 * Producer-Consumer pattern
 * @author fjab
 *
 */

public class ThreadLab_ProducerConsumer {
	
	public static void main(String[] args) {
		
		ProducerConsumer produceConsumerImpl = new ThreadLab_ProducerConsumer().new OldProduceConsumerImpl();
		produceConsumerImpl.run();
		
		
	}
	
	interface ProducerConsumer{
		void run();
		void  produce() throws InterruptedException;
		void consume() throws InterruptedException;
	}

	private class NewProduceConsumerImpl implements ProducerConsumer{
		
		private Logger logger = getLogger(getClass());
		
		private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
		public void run() {
			
			new Thread(new Runnable(){
	
				public void run() {
					try {					
						produce();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
			
			new Thread(new Runnable(){
	
				public void run() {
					try {					
						consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
	
		}
	
		public void  produce() throws InterruptedException{
			
			Random random = new Random();
			
			while(true){
				Thread.sleep(1000);
				queue.put(random.nextInt(100));
				logger.info("queue size:"+queue.size());
			}
		}
		
		public  void consume() throws InterruptedException{
			
			Random random = new Random();
			
			while(true){
				Thread.sleep(1000);
				if(random.nextInt(3)==0){			
					int element = queue.take();
					logger.info("element retrieved"+element+" -- queue size:"+queue.size());
				}
			}
		}
	
	}
	
	
	private class OldProduceConsumerImpl implements ProducerConsumer {
		
		private Logger logger = getLogger(getClass());
		
		private List<Integer> queue = new LinkedList<Integer>();
		private final static int QUEUE_LENGTH=10;
	
		public void run() {
			
			new Thread(new Runnable(){
	
				public void run() {
					try {					
						produce();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
			
			new Thread(new Runnable(){
	
				public void run() {
					try {					
						consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
			
			new Thread(new Runnable(){
				
				public void run() {
					try {					
						consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
			}).start();
	
		}
	
		public void  produce() throws InterruptedException{
			
			Random random = new Random();
			
			while(true){
				Thread.sleep(1000);
				
				synchronized(this){
					while(queue.size()==QUEUE_LENGTH){
						wait();
					}
					
					queue.add(random.nextInt(100));
					logger.info("queue size:"+queue.size());
					notify();
				}
			}
		}
		
		public void consume() throws InterruptedException{
			
			Random random = new Random();
			
			while(true){
				Thread.sleep(1000);
				if(random.nextInt(2)==0){
					
					synchronized(this){
						while(queue.size()==0){
							wait();
						}
						int element = ((LinkedList<Integer>)queue).poll();
						logger.info("element retrieved"+element+" -- queue size:"+queue.size());
						notify();
					}
				}
			}
		}
	
	}
}
