package fjab;

public class OuterClass {

	public static void main(String[] args){
		InnerClass innerClass = new OuterClass().new InnerClass();
		innerClass.run();
	}
	
	private class InnerClass{
		
		void run(){
			System.out.println("hello from inner class");
		}
	}
	
	public static class NestedStaticClass{
		
	}
}
