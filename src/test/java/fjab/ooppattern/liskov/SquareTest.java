package fjab.ooppattern.liskov;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This test illustrates the violation of Liskov's Substitution Principle
 *
 */
public class SquareTest {
	
	Rectangle rectangle;
	
	@Before
	public void setup(){
		rectangle = new Square();
	}
	
	/**
	 * This test fails because the expected behaviour of a rectangle has been overridden by Square. 
	 */
	@Test
	public void areaIs50(){
		
		rectangle.setHeight(5);
		rectangle.setWidth(10);
		
		int area = rectangle.getArea();
		
		assertEquals(50,area);
	}

}
