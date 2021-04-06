package stringquestions;
public class Palndrom {

	private static boolean isPalin(String s) {
		int len = s.length();
		for(int i=0, j=len-1; i<j;i++,j--) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "abcceba";
		if(isPalin(s)) {
			System.out.println(s + " is palindrom");
		}else {
			System.out.println(s + " is not palindrom");
		}
	}
}
