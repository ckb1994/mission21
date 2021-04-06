package greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequence {

	public static void main(String[] args) {
		ArrayList<Job> arr = new ArrayList<Job>();
		arr.add(new Job("J1", 3, 35));
        arr.add(new Job("J4", 2, 20));
        arr.add(new Job("J2", 4, 30));
        arr.add(new Job("J7", 2, 5));
        arr.add(new Job("J6", 1, 12));
        arr.add(new Job("J3", 4, 25));
        arr.add(new Job("J5", 3, 15));
        printJobScheduling(arr, 4);
	}
	static void printJobScheduling(ArrayList<Job> jobs, int maxDeadline) {
		int n = jobs.size();
//		Collections.sort(jobs,(o1, o2) -> o2.profit - o1.profit);
		Collections.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				
				return o2.profit - o1.profit;
			}
		});
		boolean[] slots = new boolean[maxDeadline];
		int[] profits = new int[maxDeadline];
		String[] job = new String[maxDeadline];
		int tempProf;
		int tempDeadLine;
		for(int i=0;i<n;i++) {
			tempProf = jobs.get(i).profit;
			tempDeadLine = jobs.get(i).deadLine;
			for(int j = Math.min(maxDeadline-1, tempDeadLine-1);j>=0;j--) {
				if(slots[j] == false) {
					slots[j] = true;
					job[j] = jobs.get(i).jobId;
					profits[j] = tempProf;
					break;
				}
			}
		}
		tempProf=0;
		for(int i=0;i<maxDeadline;i++) {
			System.out.print(job[i]+" ");
			tempProf+=profits[i];
		}
		System.out.println();
		System.out.println("Total profits are : "+ tempProf);
	}
}

class Job{
	String jobId;
	int deadLine,profit;
	
	Job(String jobId, int deadLine, int profit){
		this.jobId = jobId;
		this.deadLine = deadLine;
		this.profit = profit;
	}
}