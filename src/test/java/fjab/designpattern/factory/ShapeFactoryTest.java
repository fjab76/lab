package fjab.designpattern.factory;

import java.lang.reflect.InvocationTargetException;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ShapeFactoryTest {

	//@Before
	/*public void setup(){
		ShapeFactory.registerShape("square", Square.class);
		ShapeFactory.registerShape("circle", Circle.class);
	}*/
	
	@Test
	public void createSquare() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

		Shape square = ShapeFactory.createShape(Square.class.getName());
		
		assertThat(square, instanceOf(Square.class));
	}
	
	@Test
	public void createCircle() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		
		Shape square = ShapeFactory.createShape(Circle.class.getName());
		
		assertThat(square, instanceOf(Circle.class));
	}
	
	@Test(expected=ClassNotFoundException.class)
	public void createNonSupportedShape() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		
		ShapeFactory.createShape("nonsupported");

	}
}
