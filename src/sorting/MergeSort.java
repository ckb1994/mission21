package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1,10,4,43,5,57,91,45,9,7,97,99};
		System.out.print("Before Sorting : ");
		print(arr);
		System.out.println();
		partition(arr,0,arr.length-1);
		System.out.println();
		System.out.print("After  Sorting : ");
		print(arr);
	}
	
	public static void partition(int[] arr, int l, int h) {
		if(l<h) {
			int mid = (l+h)/2;
			partition(arr, l, mid);
			partition(arr, mid+1, h);
			merge(arr,l,mid,h);
		}
	}
	
	private static void merge(int[] arr, int l, int mid, int h) {
		int n1 = mid-l+1;// including mid
		int n2 = h-mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0;i<n1;i++) {
			left[i] = arr[l+i];
		}
		for(int i=0;i<n2;i++) {
			right[i]=arr[mid+i+1];
		}
		
		int i=0,j=0,k=l;
		while(i<n1 && j<n2) {
			if(left[i]<=right[j]) {
				arr[k++]=left[i++];
			}else {
				arr[k++]= right[j++];
			}
		}
		while(i<n1) {
			arr[k++]=left[i++];
		}
		while(j<n2) {
			arr[k++]=right[j++];
		}
		
	}

	private static void print(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}