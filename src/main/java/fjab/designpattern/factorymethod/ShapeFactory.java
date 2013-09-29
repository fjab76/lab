package fjab.designpattern.factorymethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory method design pattern is used for creating an object based on different parameters
 * 
 * Whereas the factory pattern has all the creation operations focused in one spot, the factory method pattern 
 * favours the encapsulation of the code to create every specific object in a different factory (every factory is
 * subclassed from a basic factory)

 * The use of creational patterns:
 * 1.hides complexity to create objects
 * 2.centralised the creation of objects in a single place and therefore makes it easier to add
 * new types of objects.
 * 
 * @author fjab
 *
 */
public abstract class ShapeFactory {

	  private static Map<String,ShapeFactory> factories = new HashMap<>();

	  protected abstract Shape create();

	  public static void addFactory(String id, ShapeFactory f) {
	    factories.put(id, f);
	  }
	
	  // A Template Method:
	  public static final Shape createShape(String shapeClassName) {
	
		  if(!factories.containsKey(shapeClassName)) {
			  try {
				  // Load dynamically
				  Class.forName(shapeClassName);
			  } 
			  catch(ClassNotFoundException e) {
				  throw new RuntimeException("Bad shape creation: " + shapeClassName);
			  }
	
		      // See if it was put in:
		      if(!factories.containsKey(shapeClassName)){
		    	  throw new RuntimeException("Bad shape creation: " + shapeClassName);
		      }
		
	      }
	
	      return factories.get(shapeClassName).create();
	  }
}
