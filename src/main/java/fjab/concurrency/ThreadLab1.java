package fjab.concurrency;

import static org.apache.log4j.Logger.*;

import org.apache.log4j.Logger;

public class ThreadLab1 {
	
	static long sleepingTime = 5000;
	
	Logger logger = getLogger(getClass());

	public static void main(String[] array){
		
		//Thread1 and Thread2 access 2 synchronised static methods of the same class so they are using the
		//same lock (the Class object lock of Class1)
		Thread thread1 = new Thread(new Runnable(){

			public void run() {
				Thread.currentThread().setName("thread1");
				Class1.method1();				
			}			
		}
		);
		
		Thread thread2 = new Thread(new Runnable(){

			public void run() {
				Thread.currentThread().setName("thread2");
				Class1.method2();				
			}			
		}
		);
		
		//Thread5 accesses the lock of an instance of Class1 created inside the method run()
		Thread thread5 = new Thread(new Runnable(){

			public void run() {
				Thread.currentThread().setName("thread5");
				new Class1().method3();				
			}			
		}
		);
		
		//Thread3 and Thread4 access 2 synchronised static methods of different classes so they are using different
		//locks
		Thread thread3 = new Thread(new Runnable(){

			public void run() {
				Thread.currentThread().setName("thread3");
				Class2.method1();				
			}			
		}
		);
		
		Thread thread4 = new Thread(new Runnable(){

			public void run() {
				Thread.currentThread().setName("thread4");
				Class3.method1();				
			}			
		}
		);
		
		//Using the same object to create 2 threads: every thread modifies the instance variable and the change
		//is visible for the other thread
		Runnable class4 = new Class4();
		Thread thread6 = new Thread(class4);
		Thread thread7 = new Thread(class4);
		
		//Trying to check the use of volatile
		Class5 class5 = new Class5();
		Thread thread8 = new Thread(class5);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		class5.shutdown();
	}
}

class Class1{
	
	final static Logger logger = getLogger(Class1.class);
	
	//Uses the Class object lock
	static synchronized void method1(){
		
		logger.info(Thread.currentThread().getName()+" is sleeping");
		try {
			Thread.sleep(ThreadLab1.sleepingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(Thread.currentThread().getName()+" is done");
		
	}
	
	//Uses the Class object lock
	static synchronized void method2(){
		
		logger.info(Thread.currentThread().getName()+" is sleeping");
		try {
			Thread.sleep(ThreadLab1.sleepingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(Thread.currentThread().getName()+" is done");
		
	}
	
	//Uses the instance lock
	synchronized void method3(){
		
		logger.info(Thread.currentThread().getName()+" is sleeping");
		try {
			Thread.sleep(ThreadLab1.sleepingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(Thread.currentThread().getName()+" is done");
	}
}

class Class2{
	
	final static Logger logger = getLogger(Class2.class);
	
	static synchronized void method1(){
		
		logger.info(Thread.currentThread().getName()+" is sleeping");
		try {
			Thread.sleep(ThreadLab1.sleepingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(Thread.currentThread().getName()+" is done");
		
	}
	
	static synchronized void method2(){
		
		logger.info(Thread.currentThread().getName()+" is sleeping");
		try {
			Thread.sleep(ThreadLab1.sleepingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(Thread.currentThread().getName()+" is done");
		
	}
}

class Class3{
	
	final static Logger logger = getLogger(Class3.class);
	
	static synchronized void method1(){
		
		logger.info(Thread.currentThread().getName()+" is sleeping");
		try {
			Thread.sleep(ThreadLab1.sleepingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(Thread.currentThread().getName()+" is done");
		
	}
	
	static synchronized void method2(){
		
		logger.info(Thread.currentThread().getName()+" is sleeping");
		try {
			Thread.sleep(ThreadLab1.sleepingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(Thread.currentThread().getName()+" is done");
		
	}
}

class Class4 implements Runnable{
	
	final static Logger logger = getLogger(Class4.class);
	
	private int var1 = 0;
	
	public void run(){
		//int var1 = 0;
		for(int j=0;j<5;j++) {
			logger.info(Thread.currentThread().getName()+" -- var1="+var1+"-object="+this.toString());
			var1++;
		}
	}
}

class Class5 implements Runnable{
	
	final static Logger logger = getLogger(Class5.class);
	
	//It also works without volatile
	private volatile boolean running = true;
	
	public void run(){
		while(running){
			logger.info(Thread.currentThread().getName()+"-running");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running=false;
	}
}
