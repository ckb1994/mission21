package hackerrank;

public class SherlockandtheValidString {

	public static void main(String[] args) {
		String str = "aabbc";
		System.out.println(isValid(str));
	}
	
	static String isValid(String s) {

		int len = s.length();
		int[] freq = new int[26];
		char c;
		for(int i=0;i<len;i++) {
			c = s.charAt(i);
			freq[c-97]++;
		}
		int presCount =0;
		int freqSum=0;
		int minFreq = Integer.MAX_VALUE;
		int maxFreq = Integer.MIN_VALUE;
		for(int i=0;i<26;i++) {
			if(freq[i]>0) {
				presCount++;
				freqSum+=freq[i];
				if(freq[i]<minFreq)
					minFreq = freq[i];
				else if(freq[i]>maxFreq)
					maxFreq = freq[i];
			}
			
		}
		if(freqSum - (presCount*minFreq) <= 1)
			return "YES";
		if(freqSum - (maxFreq*(presCount-1)) == 1) {
			return "YES";
		}
		return "NO";
    }
}
