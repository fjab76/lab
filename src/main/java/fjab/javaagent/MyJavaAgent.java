package fjab.javaagent;

import java.lang.instrument.Instrumentation;

public class MyJavaAgent {

	public static void premain(String agentArgument, Instrumentation instrumentation){
        System.out.println("Simple Java Agent");
        System.out.println("system class loader:"+ClassLoader.getSystemClassLoader());
        
        Class[] listOfLoadedClasses = instrumentation.getAllLoadedClasses();
        for(Class clazz : listOfLoadedClasses){
        	System.out.println("classes loaded so far:"+clazz.toString()+" by class loader:"+clazz.getClassLoader());
        }
        
        System.out.println("Registering transformer...");
        SimpleClassTransformer transformer = new SimpleClassTransformer();
        instrumentation.addTransformer(transformer);
    }
}
