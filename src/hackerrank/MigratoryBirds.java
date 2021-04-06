package hackerrank;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/migratory-birds/problem
public class MigratoryBirds {

	static int migratoryBirds(List<Integer> arr) {

		int[] hashArray = new int[5];
		for(Integer i : arr) {
			hashArray[i-1]++;
		}
		int maxFreq=0;
		for(int i=4;i>=0;i--) {
			if(hashArray[i]>maxFreq) {
				maxFreq=hashArray[i];
			}
		}
		for(int i=0;i<5;i++) {
			if(hashArray[i]==maxFreq) {
				return (i+1);
			}
		}
		
		return 0;
    }
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {{
			add(1);
			add(1);
			add(2);
			add(2);
		}};
		System.out.println(migratoryBirds(list));
	}

}
