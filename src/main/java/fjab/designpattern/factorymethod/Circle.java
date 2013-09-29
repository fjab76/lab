package fjab.designpattern.factorymethod;

public class Circle implements Shape{

	
	static{
		ShapeFactory.addFactory(Circle.class.getName(), new Factory());
	}
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	private static class Factory extends ShapeFactory{

		@Override
		protected Shape create() {
			return new Circle();
		}
	}
}
