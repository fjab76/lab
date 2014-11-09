package fjab.instrumentation;

import java.lang.reflect.Method;
import java.util.Map;

public class Instrumentation {
	
	public void doNothing() throws Exception{
		
		String composite = "Split"+"string";
		if(composite=="Splitstring"){
			System.out.println("is true");
		}
		
		//new AccessedClass().print();
		Method method = Class.forName("fjab.instrumentation.AccessedClass").getDeclaredMethod("print");
		method.setAccessible(true);
		method.invoke(new AccessedClass(), null);
	}
	
	public static void main(String[] args) throws Exception{
		new Instrumentation().doNothing();
	}
	

}
