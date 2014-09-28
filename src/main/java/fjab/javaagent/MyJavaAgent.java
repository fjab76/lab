package fjab.javaagent;

import java.lang.instrument.Instrumentation;

public class MyJavaAgent {

	public static void premain(String agentArgument, Instrumentation instrumentation){
        System.out.println("Test Java Agent");
    }
}
