package fjab.interviews;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class QueueImpl {

	public static void main(String[] args) {
		
		LinkedList<Element> queue = new  LinkedList<>();
		PriorityQueue<Element> priorityQueue = new PriorityQueue<> ();
		Random random = new Random();
		
		//Adding elements
		for(int j=0; j<10; j++){
			
			Element element = new Element(random.nextInt(),random.nextInt());
			queue.add(element);
			priorityQueue.add(element);
			System.out.println("added new element "+element.toString());
		}
		
		//Retrieving elements
		for(int j=0; j<10; j++){			
			Element element = queue.remove();
			Element element2 = priorityQueue.remove();
			//System.out.println("removed element "+element.toString());
			System.out.println("removed element "+element2.toString());
		}

	}
	
	private static class Element implements Comparable<Element>{
		
		private int field1;
		private int field2;
		
		private Element(int field1,int field2){
			this.field1=field1;
			this.field2=field2;
		}
		
		public String toString(){
			return "field1="+field1+": field2="+field2+": sum="+(field1+field2);
		}

		@Override
		public int compareTo(Element o) {
			
			return (this.field1+this.field2) - (o.field1+o.field2);
		}

		
	}

}
