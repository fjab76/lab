package fjab.ooppattern.liskov;

/**
 * Square is extending Rectangle and changing the expected behaviour of a Rectangle. By doing so, it is violating Liskov's Substitution
 * Principle and the results can be checked out in the corresponding unit test.
 * 
 * This also is a violation of the Open Closed Principle as we are changing existing code (the code of the base class' methods) to
 * extend functionality. According to OCP, new functionality must be added by adding new code (new methods, new classes)
 *
 */
public class Square extends Rectangle {
	
	public void setWidth(int width){
		super.setWidth(width);
		super.setHeight(width);
	}
	
	public void setHeight(int height){
		super.setWidth(height);
		super.setHeight(height);
	}

}
