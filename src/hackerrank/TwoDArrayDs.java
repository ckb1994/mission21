package hackerrank;


//https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class TwoDArrayDs {

	static int sum(int[][] arr, int i, int j) {
		return arr[i][j]+ arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
	}
	 static int hourglassSum(int[][] arr) {

		 int max = Integer.MIN_VALUE;
		 int temp;
		 for(int i=0;i<4;i++) {
			 for(int j=0;j<4;j++) {
				 temp = arr[i][j]+ arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				 if(i==0 &&j==0) {
					 max = temp;
				 }else if(temp>max){
					 max = temp;
				 }
			 }
		 }
		 return max;
	    }

	
	public static void main(String[] args) {
		int[][] arr = {{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
		System.out.println(hourglassSum(arr));
	}
}
