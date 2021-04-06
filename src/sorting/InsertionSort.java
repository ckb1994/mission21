package sorting;

//O(n*n)

public class InsertionSort {
	
	private static void print(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
	public static void main(String[] str) {
		
		int[] arr = {1,10,4,43,5,57,91,45,9,7,97,99};
//		int[] arr = {1,2,3,4,5,6,7,8};
		System.out.print("Before Sorting : ");
		print(arr);
		System.out.println();
		insertion(arr);
		System.out.println();
		System.out.print("After  Sorting : ");
		print(arr);
	}


	private static void insertion(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		int key;
		int j;
		for(int i=1;i<len;i++) {
			key = arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1]= arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
	}
}
