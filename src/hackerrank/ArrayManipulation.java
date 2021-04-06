package hackerrank;
//https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {
		long[] arr = new long[n];
		int row = queries.length;
		int start,end,key;
		long max=0;
		for(int i=0;i<row;i++) {
			start = queries[i][0] -1;
			end = queries[i][1] -1;
			key = queries[i][2];
			for(int j=start;j<=end;j++) {
				arr[j]+=key;
				if(arr[j]>max)
					max=arr[j];
			}
		}
		return max;

    }
	
	static long arrayManipulationOptimised(int n, int[][] queries) {
		long[] arr = new long[n+1];
		int row = queries.length;
		int start,end,key;
		
		for(int i=0;i<row;i++) {
			start = queries[i][0] -1;
			end = queries[i][1] -1;
			key = queries[i][2];
			arr[start]=arr[start] + key;
			arr[end+1] = arr[end+1] - key;
			
		}
		long max=arr[0];
		for(int i=1;i<=n;i++) {
			arr[i]=arr[i]+arr[i-1];
			if(arr[i]>max)
				max = arr[i];
		}
		return max;

    }
	public static void main(String[] args) {
		int[][] arr = {{1,2,100},{2,5,100},{3,4,100}};
		System.out.println(arrayManipulationOptimised(5, arr));
	}
}
