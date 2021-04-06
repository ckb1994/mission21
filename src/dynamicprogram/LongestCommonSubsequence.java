package dynamicprogram;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "bd";

		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		lcs.solveLcs(str1, str2);
	}

	private void solveLcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int[][] lcs = new int[n+1][m+1];
		for(int i=-1;i<n;i++) {
			for(int j= -1 ; j<m ;j++) {
//				System.out.println(i + " : " + j);
				if(i==-1 || j== -1) {
					lcs[i+1][j+1]=0;
				}else {
					if(str2.charAt(i) ==  str1.charAt(j)) {
						lcs[i+1][j+1] = 1 + lcs[i][j];
					}else {
						lcs[i+1][j+1] = Math.max(lcs[i+1][j], lcs[i][j+1]);
					}
				}
			}
		}
		System.out.println("LCS of "+ str1 + " and "+ str2 + " is : ");
		printLcs(lcs,m,n, str2);
	}

	private void printLcs(int[][] lcs, int m, int n, String str2) {
		// lcs = n+1 * m+1
		int i=n;
		int j=m;
		char[] lcsList = new char[lcs[i][j]];
		int k=0;
		while(i>0 && j>0) {
			if(lcs[i][j] == lcs[i][j-1]) {
				j--;
			}else if(lcs[i][j] > lcs[i][j-1]) {
				lcsList[k++]=str2.charAt(i-1);// if using i then use str2, if j then use str1
				i--;j--;
			}else {
				continue;
			}
		}
		for(i=lcsList.length -1 ; i>=0; i--) {
			System.out.print(lcsList[i]);
		}
	}
}
