package fjab.designpattern.abstractfactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class ShapeAbstractFactoryTest {

	
	@Test
	public void createSquare() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

		ShapeAbstractFactory shapeFactory = ShapeAbstractFactory.getFactory("2D");
		
		assertThat(shapeFactory.createSquareShape(), instanceOf(Square.class));
	}
	
	@Test
	public void createCircle() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

		ShapeAbstractFactory shapeFactory = ShapeAbstractFactory.getFactory("2D");
		
		assertThat(shapeFactory.createCircleShape(), instanceOf(Circle.class));
	}
	
	@Test
	public void createCube() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

		ShapeAbstractFactory shapeFactory = ShapeAbstractFactory.getFactory("3D");
		
		assertThat(shapeFactory.createSquareShape(), instanceOf(Cube.class));
	}
	
	@Test
	public void createSphere() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

		ShapeAbstractFactory shapeFactory = ShapeAbstractFactory.getFactory("3D");
		
		assertThat(shapeFactory.createCircleShape(), instanceOf(Sphere.class));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nonExistingFactory() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

		ShapeAbstractFactory shapeFactory = ShapeAbstractFactory.getFactory("unknown factory");
	}
}
