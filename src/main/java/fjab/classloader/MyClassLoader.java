package fjab.classloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {


	public MyClassLoader(URL[] urls) {
		super(urls);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
		
		System.out.println("system classloader:"+ClassLoader.getSystemClassLoader());
		//Box a = new Box();
		//System.out.println("a classloader:"+a.getClass().getClassLoader());
		MyClassLoader myLoader = new MyClassLoader(new URL[]{new URL("file:/tmp/")});
		Class clazz = myLoader.loadClass("fjab.classloader.MyClassLoader$Box");
		Object obj = clazz.newInstance();
		System.out.println("obj classloader:"+obj.getClass().getClassLoader());
		Box b = (Box)obj;    // this always throws ClassNotFoundException.

	}
	

	
	public static class Box{
		
	}

}
