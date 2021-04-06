package stringquestions;
//https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class SpecialStirngAgain {

	static long substrCount(int n, String s) {

		String temp;
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				temp = s.substring(i, j+1);
				if(isSplPalindrom(temp.length(), temp))
					System.out.println(temp);
			}
		}
		return 0L;
    }
	
	private static boolean isSplPalindrom(int len, String s) {
		char tmp = s.charAt(0);
		for(int i=0, j=len-1;i<j;i++,j--)
			if(s.charAt(i) != tmp || s.charAt(j) != tmp)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
//		substrCount(7, "abcbaba");
		System.out.println(countspecialPalindrom("aabaaab"));
	}
	
	static int countspecialPalindrom(String str) {
		int len = str.length();
		int[] arr = new int[len];
		int total=0;
		int freq =0;
		int i=0, j=0;
		while(i<len) {
			freq =1;
			j= i+1;
			while(j<len && str.charAt(i) == str.charAt(j)) {
				freq++;
				j++;
			}
			total += freq * (freq+1)/2;
			arr[i] = freq;
			i=j;
		}
		
		for(i=1;i<len;i++) {
			if(str.charAt(i) == str.charAt(i-1)) {
				arr[i] = arr[i-1];
			}
			
			//checking for differen char in middle
			if(i< (len -1) && str.charAt(i-1) == str.charAt(i+1) && str.charAt(i) != str.charAt(i+1)) {
				total += Math.min(arr[i-1], arr[i+1]);
			}
		}
		
		
		return total;
	}
}
