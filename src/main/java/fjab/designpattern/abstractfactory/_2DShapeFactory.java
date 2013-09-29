package fjab.designpattern.abstractfactory;

public class _2DShapeFactory extends ShapeAbstractFactory{

	@Override
	public CircleShape createCircleShape() {
		return new Circle();
	}

	@Override
	public SquareShape createSquareShape() {
		return new Square();
	}

}
