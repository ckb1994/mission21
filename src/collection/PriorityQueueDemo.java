package collection;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		int[] arr = {3,4,1,5,9,6,8,4};
		pqOpe(arr);
	}
	static void pqOpe(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		while(pq.size()>0) {
			System.out.println(pq.poll());
		}
	}
}
