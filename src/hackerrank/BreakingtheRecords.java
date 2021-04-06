package hackerrank;

import java.util.HashSet;
import java.util.Set;

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
public class BreakingtheRecords {

	public static int[] breakingRecords(int[] scores) {
		int minBase=scores[0];
		int maxBase = scores[0];
		int max=0;
		int min=0;
		int len = scores.length;
		
		for(int i=1;i<len;i++) {
			if(scores[i] > maxBase) {
				max++;
				maxBase = scores[i];
				System.out.println(maxBase);
				
			}
			else if(scores[i] < minBase){
				min++;
				minBase = scores[i];
			}
		}
		System.out.println("Max : " + max +", Min : "+ min);
		return new int[] {max,min};
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
		breakingRecords(arr);
	}

}
