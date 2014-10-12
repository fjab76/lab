package fjab.innerclass.explicit;

public class InnerClass {
	
	private int innerVariable;
	final OuterClass this$0;
	
	private InnerClass(OuterClass outerClass){
		
		this$0 = outerClass;
		innerVariable = OuterClass.access$0(outerClass) + 1;
		
	}
	
	public void print(){
		System.out.println(OuterClass.access$0(this$0));
	}

}
