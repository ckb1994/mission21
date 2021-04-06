
public class StringCompare {

	public static void main(String[] args) {
		String a="123";
		String b= new Integer(123).toString();
		if(a==b) {
			System.out.println("Equals by == operator");
		}else {
			System.out.println("Not Equal by == operator");
		}
		
		if(a.equals(b)) {
			System.out.println("Equals by equals method");
		}else {
			System.out.println("Not Equals by equals method");
		}
	}

}
