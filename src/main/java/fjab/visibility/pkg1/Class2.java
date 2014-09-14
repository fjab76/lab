package fjab.visibility.pkg1;

public class Class2 {
	
	public void method(){
		
		Class1 class1 = new Class1();
		System.out.println(class1.publicMember);
		System.out.println(class1.protectedMember);
		System.out.println(class1.packagePrivateMember);		
	}

}
