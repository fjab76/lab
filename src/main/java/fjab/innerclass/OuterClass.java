package fjab.innerclass;

public class OuterClass {

	private int outerVariable;
	
	private static int staticVariable;
	
	
	private class InnerClass{
				
		private int innerVariable = outerVariable + 1;
		
		public void print(){
			System.out.println(outerVariable);
		}
		
	}
	
	public static class NestedStaticClass{
		
		private int nestedVariable = staticVariable + 1;
		
		public void print(){
			System.out.println(staticVariable);
		}
		
	}
}
