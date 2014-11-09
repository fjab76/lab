package fjab.instrumentation;

public class AccessedClass {
	
	private void print(){
		System.out.println("printing from inside private method");
		Thread.dumpStack();
	}

}
