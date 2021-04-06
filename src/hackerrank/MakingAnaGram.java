package hackerrank;
//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class MakingAnaGram {

	static int makeAnagram(String a, String b) {
		int[] aCount = new int[26];
		int[] bCount = new int[26];
		int aLen = a.length();
		int bLen = b.length();
		for(int i=0;i<aLen;i++) {
			aCount[a.charAt(i) - 97]++;
		}
		for(int i=0;i<bLen;i++) {
			bCount[b.charAt(i) - 97]++;
		}
		int count=0;
		for(int i=0;i<26;i++) {
			count+= Math.abs(aCount[i] - bCount[i]);
		}
		return count;
    }
	
	public static void main(String[] args) {
		String a = "cde";
		String b = "dcf";
		System.out.println(makeAnagram(a, b));
	}

}
