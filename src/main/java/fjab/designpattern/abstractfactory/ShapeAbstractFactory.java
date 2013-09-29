package fjab.designpattern.abstractfactory;

/**
 * This abstract factory creates factories to create circle and square shapes.
 * There is factory to create these shapes in 2D and other to create these shapes in 3D
 * 
 * @author fjab
 *
 */
public abstract class ShapeAbstractFactory {

	public abstract CircleShape createCircleShape();
	public abstract SquareShape createSquareShape();
	
	
	public static ShapeAbstractFactory getFactory(String factoryName){
		
		if("2D".equals(factoryName)){
			return new _2DShapeFactory();
		}
		else if("3D".equals(factoryName)){
			return new _3DShapeFactory();
		}
		else{
			throw new IllegalArgumentException();
		}
	}
}
