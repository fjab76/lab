package fjab.designpattern.singleton;

//Early instantiation using implementation with static field.
public class SingletonEarlyInstantiation
{
	private static SingletonEarlyInstantiation instance = new SingletonEarlyInstantiation();

	private SingletonEarlyInstantiation()
	{
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingletonEarlyInstantiation getInstance()
	{    
		return instance;
	}

	public void doSomething()
	{
		System.out.println("doSomething(): Singleton does something!");
	}
}
