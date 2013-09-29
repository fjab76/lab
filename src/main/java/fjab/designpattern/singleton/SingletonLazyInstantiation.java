package fjab.designpattern.singleton;

//Early instantiation using implementation with static field.
public class SingletonLazyInstantiation
{
	private static SingletonLazyInstantiation instance;

	private SingletonLazyInstantiation()
	{
		System.out.println("Singleton(): Initializing Instance");
	}

	public static synchronized SingletonLazyInstantiation getInstance()
	{    
		if(instance==null){
			instance = new SingletonLazyInstantiation();
		}
		return instance;
	}

	public void doSomething()
	{
		System.out.println("doSomething(): Singleton does something!");
	}
	
	
	/**
	 * This idiom is not secure and should not be used
	 * @see http://www-128.ibm.com/developerworks/java/library/j-dcl.html?loc=j
	 * @return
	 */
	public static SingletonLazyInstantiation getInstanceUsingDoubleCheck()
	{    
		if(instance==null){
			
			synchronized(SingletonLazyInstantiation.class){
				if(instance==null){
					instance = new SingletonLazyInstantiation();
				}
				
			}
		}
		return instance;
	}
}
