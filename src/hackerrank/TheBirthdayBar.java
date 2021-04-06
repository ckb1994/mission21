package hackerrank;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/the-birthday-bar/problem
public class TheBirthdayBar {

	public static int birthdayBar(List<Integer> s, int month, int day) {
		int n= s.size();
		int sum=0;
		int count=0;
		for(int i=0;i<=n-month;i++) {
			sum=0;
			for(int j=0;j<month;j++) {
				sum+=s.get(i+j);
			}
			if(sum==day) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
	public static void main(String[] args) {
//		List<Integer> arr = new ArrayList<Integer>(){{
//            add(1);
//            add(2);
//            add(1);
//            add(3);
//            add(2);
//            } };
//		
		
		List<Integer> arr = new ArrayList<Integer>(){{
            
            add(4);
            } };
		
		int day = 4;
		int month =1;
		birthdayBar(arr, month, day);
	}

}
