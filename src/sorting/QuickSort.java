package sorting;


// worst case and best case depend on pivot selection
//worst case O(n^2)
//Best case nlogn
// space complexity logn to n

// select pivot and divide into two

public class QuickSort {


	static int partition(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l+1;
		int j= h;
		int temp;
		while(i<j) {
			while(arr[i]<=pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			if(i<j) {
				temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		
		temp = arr[l];
		arr[l]=arr[j];
		arr[j]=temp;
		
		return j;
	}

	public static void main(String[] args) {
		int[] arr = {10,5,8,9,3,6,15,12,16};
		System.out.print("Arrays are : ");
		printArray(arr);
		System.out.println();
		quickSort(arr,0,arr.length-1);
		System.out.print("Array after quickSort : ");
		printArray(arr);
	}
	
	private static void quickSort(int[] arr, int l, int h) {
		if(l<h) {
			int j= partition(arr, l, h);
			quickSort(arr, 0, j-1);
			quickSort(arr, j+1, h-1);
		}
		
	}

	public static void printArray(int[] arr) {
		int len = arr.length;
		for(int i=0;i<len;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}

