package sorting;


//swapping adjancent if not in sorting order
//worst case and best case scenario have Time Complexity O(n^2)
//After making it optimized using flag, best case scenario Time Complexity O(n)
//Space complexity O(1)

public class BubbleSort {
	
	
	private static void print(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void bubbleSort(int[] arr) {
		
		int length = arr.length;
		int temp=0;
		boolean flag = false;
		int i;
		
		for(i=0;i<length-1 && flag == false;i++) {
			flag = true;
			for(int j=0;j<length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag = false;
				}
			}
		}
		System.out.print("Number of outer loop run : "+ i);
	}
	

	public static void main(String[] args) {
		int[] arr = {1,10,4,43,5,57,91,45,9,7,97,99};
		System.out.print("Before Sorting : ");
		print(arr);
		System.out.println();
		bubbleSort(arr);
		System.out.println();
		System.out.print("After  Sorting : ");
		print(arr);
	}

}
