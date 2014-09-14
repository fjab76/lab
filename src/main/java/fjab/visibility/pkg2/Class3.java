package fjab.visibility.pkg2;

import fjab.visibility.pkg1.Class1;

public class Class3 extends Class1{
	
	public void method(){
		
		Class1 class1 = new Class1();
		System.out.println(class1.publicMember);
		System.out.println(super.publicMember);
		System.out.println(super.protectedMember);
		
		//Not permitted: according to JLS (Java Language Specification) 6.6.2, the access is only permitted
		//through Class3 or a sublclass or Class3
		//System.out.println(class1.protectedMember);

		Class3 class3 = new Class3();
		System.out.println(class3.publicMember);
		System.out.println(class3.protectedMember);
	}
	
	@Override
	public void publicMethod(){
		
	}
	
	@Override
	protected void protectedMethod(){
		
	}

}
