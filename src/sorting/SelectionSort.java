package sorting;

//select smallest/largest in unsorted section and place it to leftmost/righmost unsorted section
//in all case, time complexity O(n^2)
//swapping time can be minimised after filtering unwanted swap
public class SelectionSort {

	private static void print(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
 		int[] arr = {1,10,4,43,5,57,91,45,9,7,97,99};
//		int[] arr = {1,2,3,4,5,6,7,8};
		System.out.print("Before Sorting : ");
		print(arr);
		System.out.println();
		selection(arr);
		System.out.println();
		System.out.print("After  Sorting : ");
		print(arr);
	}



	private static void selection(int[] arr) {
		int length = arr.length;
		int min, tmp;
		int c = 0;
		for(int i=0; i< length-1;i++) {
			min = i;
			for(int j=i+1; j<length ; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			if(min != i) {
				c++;
				tmp = arr[min];
				arr[min] = arr[i];
				arr[i] = tmp;
			}
			
		}
		System.out.println("Number of swap happened : "+ c);
	}
}
