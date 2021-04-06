
public class InstanceVsStatic {

	static int c = 4;
	int d = 5;
	
	public static void main(String[] args) {
		InstanceVsStatic s = new InstanceVsStatic();
		System.out.println(a+ ":"+s.b+":"+c+":"+s.d);
	}
	
	static int a = 2;
	int b = 3;
}
