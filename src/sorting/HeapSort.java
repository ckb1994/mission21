package sorting;

public class HeapSort {

	
	public static void printArray(int[] arr) {
		int n = arr.length;
		for(int i =0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void heapSort(int[] arr) {
		int n = arr.length;
		int temp;
		//created heap from given arr
		for(int i=n/2;i>=0;i--) {
			heapifyArray(arr, n, i);
		}
		System.out.print("After Creating Max Heap ");printArray(arr);
		
		// sorting now
		for(int i=n-1;i>=0;i--) {
			temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;           
			
			heapifyArray(arr, i, 0);
		}
	}
	
	public static void heapifyArray(int[] arr, int n, int rooti) {
		int largest = rooti;
		int left = rooti*2 +1;
		int right = rooti*2 +2;
		int tmp;
		if(left<n && arr[left] > arr[largest]) {
			largest = left;
		}
		if(right<n && arr[right] > arr[largest]) {
			largest = right;
		}
		if(rooti!=largest) {
			tmp= arr[rooti];
			arr[rooti]=arr[largest];
			arr[largest]= tmp;
			
			heapifyArray(arr, n, largest);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;
 
 
        System.out.print("UnSorted array is ");
        printArray(arr);
        
        heapSort(arr);
        System.out.print("Sorted array is ");
        printArray(arr);
	}
}
