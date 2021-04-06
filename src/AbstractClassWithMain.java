
public abstract class AbstractClassWithMain {
	
	public static void m1() {
		System.out.println("m1");
	}
	
	public abstract void m1(String s);
	
	public abstract void m2();
	
	public static void main(String[] args) {
		AbstractClassWithMain.m1();
	}
}
