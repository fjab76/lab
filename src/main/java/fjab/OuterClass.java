package fjab;

public class OuterClass {

	private int outerVariable;
	
	private class InnerClass{
		
		private int innerVariable = outerVariable + 1;
		
	}
	
	public static class NestedStaticClass{
		
	}
}
