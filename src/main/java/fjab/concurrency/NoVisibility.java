package fjab.concurrency;

/**
 * NoVisibility could loop  forever because the value of  ready might never  become visible  to the reader thread.  Even 
 * more strangely,  NoVisibility could print zero because the write to  ready might be made visible to the reader thread 
 * before the write to  number, a phenomenon known as reordering. There is no guarantee that operations in one thread 
 * will be performed in the order given by the program, as long as the reordering is not detectable from within that thread 
 * even if the reordering is apparent to other threads
 * 
 * @author fjab
 *
 */
public class NoVisibility {

	private boolean ready;
	private int number;
	
	private class ReaderThread extends Thread {
		public void run() {
			while (!ready)
				Thread.yield();
			if(number!=42){
				throw new RuntimeException();
			}
		}
	}
	
	private class NewThread extends Thread{

		@Override
		public void run() {
			Thread reader = new ReaderThread();
			reader.start();
			number = 42;
			ready = true;
			try {
				reader.join(1000);
				if(reader.isAlive()){
					throw new RuntimeException();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("end");
		}
		
	}
	
	public static void main(String[] args) {
		
		while(true){
			new NoVisibility().new NewThread().start();
		}
	}

}
