package greedyalgorithm;

import java.util.PriorityQueue;

public class OptimalMergePattern {

	public static void main(String[] args) {
		int[] files = {20,30,10,5,30};
		System.out.println(printMinimumCost(files));
	}

	private static int printMinimumCost(int[] files) {
		int size = files.length;
		//min heap by default
		// poll means it is deleting so automaticaly sorted order data will come, heap sort
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<size;i++) {
			pq.add(files[i]);
		}
		int minCost=0;
		int temp;
		while(pq.size()>1) {
			temp = pq.poll() + pq.poll();
			minCost+= temp;
			pq.add(temp);
		}
		return minCost;
	}
}
