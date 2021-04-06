package hackerrank;


//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
public class DivisibleSumPairs {

	static int divisibleSumPairs(int n, int k, int[] ar) {
		
		int count=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if((ar[i]+ar[j])%k == 0)
					count++;
			}
		}
		
		return count;

    }

	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 6, 1, 2};
		int n=6;
		int k=3;
		System.out.println(divisibleSumPairs(n, k, arr));
	}

}
