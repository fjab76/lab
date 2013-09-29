package fjab.designpattern.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory design pattern is used for creating an object based on different parameters
 * It forces all the creation operations to be focused in one spot, so that’s the only place 
 * you need to change the code
 * 
 * The use of creational patterns:
 * 1.hides complexity to create objects
 * 2.centralised the creation of objects in a single place and therefore makes it easier to add
 * new types of objects.
 * 
 * @author fjab
 *
 */
public abstract class ShapeFactory {


	//============= FIRST APPROACH
/*	public static Shape createShape(String shapeType){
		
		if("square".equals(shapeType)){
			return new Square();
		}
		else if("circle".equals(shapeType)){
			return new Circle();
		}
		else{
			throw new IllegalArgumentException("the argument:"+shapeType+" is not accepted");
		}
			
	}*/
	
	
	//============= SECOND APPROACH	(class registration using reflection)
	private static Map<String,Class<? extends Shape>> registeredShapes = new HashMap<>();
	
	public static void registerShape(String name,Class<? extends Shape> classObject){
		registeredShapes.put(name, classObject);
	}
	
	/*public static Shape createShape(String shapeType) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<? extends Shape> shapeClass = registeredShapes.get(shapeType);
		if(shapeClass==null){
			throw new IllegalArgumentException("the argument:"+shapeType+" is not accepted");
		}
		
		//=====> It is only possible to get public constructors by reflection
		//Otherwise, we could declare Shape subclasses' constructors as package-access for them
		//only been able to be created through the ShapeFactory.
		Constructor<? extends Shape> constructor = shapeClass.getConstructor();
		return constructor.newInstance();
			
	}*/
	
	//============= THIRD APPROACH	(no previous class registration)
	@SuppressWarnings("unchecked")
	public static Shape createShape(String shapeType) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		
		Class<? extends Shape> shapeClass = (Class<? extends Shape>) Class.forName(shapeType);
		
		//=====> It is only possible to get public constructors by reflection
		//Otherwise, we could declare Shape subclasses' constructors as package-access for them
		//only been able to be created through the ShapeFactory.
		Constructor<? extends Shape> constructor = shapeClass.getConstructor();
		return constructor.newInstance();
			
	}
}
