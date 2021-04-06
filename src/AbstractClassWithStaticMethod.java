
public class AbstractClassWithStaticMethod extends Test{

	@Override
	public void m2() {
		System.out.println("overridden m2 method");
	}
	
	public static void m3() {
		System.out.println("Extended class static m3 method");
	}
	
	public static void main(String[] args) {
		Test a = new AbstractClassWithStaticMethod();
		a.m2();
		a.m1();
		a.m3();
	}
}


abstract class Test{
	public void m1() {
		System.out.println("Abstract class m1 mthod");
	}
	public abstract void m2();
	public static void m3() {
		System.out.println("Abstract class static m3 method");
	}
}