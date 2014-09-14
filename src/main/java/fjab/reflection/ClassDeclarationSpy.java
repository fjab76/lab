package fjab.reflection;

/*

For every type of object, the Java virtual machine instantiates an immutable instance of java.lang.Class which 
provides methods to examine the runtime properties of the object including its members and type information. 
Class also provides the ability to create new classes and objects. 
Most importantly, it is the entry point for all of the Reflection APIs

 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.System.out;

public class ClassDeclarationSpy {
	
	private enum Example{
		A,B;
	}	
	
    public static void main(String... args) {
		try {
		    //Class<?> c = Class.forName(args[0]);
			//Class<?> c = Example.class;
			//Class<?> c =   ((Consumer<?>)x -> System.out.println("")).getClass();
			Class<?> c = new int[]{1,2}.getClass();
		    out.format("Class:%n  %s%n%n", c.getCanonicalName());
		    out.format("Modifiers:%n  %s%n%n",Modifier.toString(c.getModifiers()));
	
		    out.format("Type Parameters:%n");
		    TypeVariable[] tv = c.getTypeParameters();
		    if (tv.length != 0) {
				out.format("  ");
				for (TypeVariable t : tv)
				    out.format("%s ", t.getName());
				out.format("%n%n");
		    } else {
		    	out.format("  -- No Type Parameters --%n%n");
		    }
	
		    out.format("Implemented Interfaces:%n");
		    Type[] intfs = c.getGenericInterfaces();
		    if (intfs.length != 0) {
				for (Type intf : intfs)
				    out.format("  %s%n", intf.toString());
				out.format("%n");
		    } else {
		    	out.format("  -- No Implemented Interfaces --%n%n");
		    }
	
		    out.format("Inheritance Path:%n");
		    List<Class> l = new ArrayList<Class>();
		    printAncestor(c, l);
		    if (l.size() != 0) {
				for (Class<?> cl : l)
				    out.format("  %s%n", cl.getCanonicalName());
				out.format("%n");
		    } else {
		    	out.format("  -- No Super Classes --%n%n");
		    }
	
		    out.format("Annotations:%n");
		    Annotation[] ann = c.getAnnotations();
		    if (ann.length != 0) {
				for (Annotation a : ann)
				    out.format("  %s%n", a.toString());
				out.format("%n");
		    } else {
		    	out.format("  -- No Annotations --%n%n");
		    }
	
	        // production code should handle this exception more gracefully
		} catch (Exception x) {
		    x.printStackTrace();
		}
	    }
	
	    private static void printAncestor(Class<?> c, List<Class> l) {
		Class<?> ancestor = c.getSuperclass();
	 	if (ancestor != null) {
		    l.add(ancestor);
		    printAncestor(ancestor, l);
	 	}
    }
}
