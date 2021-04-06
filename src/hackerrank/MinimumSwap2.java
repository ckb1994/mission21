package hackerrank;

public class MinimumSwap2 {

	static int minimumSwaps(int[] arr) {

		int len = arr.length;
		int i=0;
		int count =0;
		int temp;
		while(i<len) {
			if(arr[i]!= (i+1)) {
				temp = arr[i];
				arr[i] = arr[temp-1];
				arr[temp-1] = temp;
				count++;
			}else {
				i++;
			}
		}
		return count;
    }
	
	public static void main(String[] args) {
		int[] arr = {7, 1, 3, 2, 4, 5, 6};
		System.out.println(minimumSwaps(arr));
	}

}
