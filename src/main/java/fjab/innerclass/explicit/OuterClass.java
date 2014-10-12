package fjab.innerclass.explicit;

public class OuterClass {
	
	private int outerVariable;
	
	private static int staticVariable;
	
	static int access$0(OuterClass outerClass){
		
		return outerClass.outerVariable;
	}
	
	static int access$1(){
		return staticVariable;
	}

}
