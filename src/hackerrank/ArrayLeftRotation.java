package hackerrank;
//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

public class ArrayLeftRotation {
	
	static int[] rotLeft(int[] a, int d) {
		int len  = a.length;
		int[] arr = new int[len];
		
		for(int i=d;i<len;i++) {
			arr[i-d]=a[i];
		}
		for(int i=0;i<d;i++) {
			arr[len-d+i] = a[i];
		}
		
		return arr;
    }
	
	static void printArray(int[] arr) {
		int len = arr.length;
		for(int i=0;i<len;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		printArray(arr);
		arr = rotLeft(arr, 2);
		printArray(arr);
	}
}
