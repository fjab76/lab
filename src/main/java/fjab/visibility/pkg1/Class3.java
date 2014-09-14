package fjab.visibility.pkg1;

public class Class3 extends Class1{

	public void method(){
		
		Class1 class1 = new Class1();
		System.out.println(class1.publicMember);
		System.out.println(class1.protectedMember);
		System.out.println(class1.packagePrivateMember);
		
		System.out.println(super.publicMember);
		System.out.println(super.protectedMember);
		System.out.println(super.packagePrivateMember);
	}
	
	@Override
	public void publicMethod(){
		
	}
	
	@Override
	protected void protectedMethod(){
		
	}
	
	@Override
	void packagePrivateMethod(){
		
	}
}
