package fjab.designpattern.factorymethod;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import fjab.designpattern.factory.Circle;
import fjab.designpattern.factory.Shape;
import fjab.designpattern.factory.ShapeFactory;
import fjab.designpattern.factory.Square;

public class ShapeFactoryTest {

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
