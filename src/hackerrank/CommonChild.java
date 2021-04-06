package hackerrank;
//https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

public class CommonChild {
// largest common subsequence problem
	public static void main(String[] args) {
		String s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
		String s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";
		System.out.println(commonChild(s1, s2));
	}
	static int commonChild(String s1, String s2) {
		int len = s1.length();
		char c1;
		int temp=-1;
		int count1=0;
		for(int i=0;i<len;i++) {
			c1 = s1.charAt(i);
			for(int j=temp+1;j<len;j++) {
				if(c1 == s2.charAt(j)) {
					count1++;
					temp=j;
					break;
				}
			}
		}
		char c2;
		temp=-1;
		int count2=0;
		for(int i=0;i<len;i++) {
			c2 = s2.charAt(i);
			for(int j=temp+1;j<len;j++) {
				if(c2 == s1.charAt(j)) {
					count2++;
					temp=j;
					break;
				}
			}
		}
		return count1>count2?count1:count2;
    }
}
