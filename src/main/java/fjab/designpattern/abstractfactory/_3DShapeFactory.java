package fjab.designpattern.abstractfactory;

public class _3DShapeFactory extends ShapeAbstractFactory{

	@Override
	public CircleShape createCircleShape() {
		return new Sphere();
	}

	@Override
	public SquareShape createSquareShape() {
		return new Cube();
	}

}
