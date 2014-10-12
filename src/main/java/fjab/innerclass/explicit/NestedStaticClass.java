package fjab.innerclass.explicit;

public class NestedStaticClass {
	
	private int nestedVariable;
	
	public NestedStaticClass(){
		
		nestedVariable = OuterClass.access$1() + 1;
		
	}
	
	public void print(){
		System.out.println(OuterClass.access$1());
	}

}
