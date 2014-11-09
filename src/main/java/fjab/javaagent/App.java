package fjab.javaagent;

import java.lang.invoke.MethodHandles;

/**
 * http://www.javabeat.net/introduction-to-java-agents/
 * @author fjab
 *
 */
public class App {

	public static void main(String[] args) {
		
		System.out.println("App class");		
		System.out.println("system class loader:"+ClassLoader.getSystemClassLoader());
		
		ClassLoader classLoader = MethodHandles.lookup().lookupClass().getClassLoader();
		do{
			System.out.println("class loader parent:"+classLoader);
			classLoader = classLoader.getParent();
		}while(classLoader!=null);
		
	}

}
