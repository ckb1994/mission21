package hackerrank;
//https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class AlterNatingChars {

	public static void main(String[] args) {
		String s = "AAABBB";
		System.out.println(alternatingCharacters(s));
	}
	static int alternatingCharacters(String s) {

		int count=0;
		char c1,c2;
		int len = s.length();
		c1= s.charAt(0);
		for(int i=1;i<len;i++) {
			c2=s.charAt(i);
			if(c1==c2)
				count++;
			c1=c2;
		}
		return count;
    }
}
