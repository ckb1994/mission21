package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

	public static void main(String[] args) {
		int[] wt = {10,40,20,30};
		int[] prof = {60, 40, 100, 120};
		int capacity = 50;
		double maxProfit = getMaxProfit(wt,prof,capacity);
		System.out.println(maxProfit);
	}

	private static double getMaxProfit(int[] wt, int[] prof, int capacity) {
		int len = wt.length;
		ItemDetail[] items = new ItemDetail[len];
		for(int i=0;i<len;i++) {
			items[i] = new ItemDetail(wt[i], prof[i]);
		}
		
		Arrays.sort(items, new Comparator<ItemDetail>() {

			@Override
			public int compare(ItemDetail o1, ItemDetail o2) {
				
				return o2.ppw.compareTo(o1.ppw);
			}
		});
		
		//Object is sorted based on ppw in decreasing order
		
		double maxProfit = 0d;
		int currWt,currProf;
		for(ItemDetail item : items) {
			currWt = item.wt;
			currProf = item.prof;
			if(capacity - currWt >= 0) {
				// taking whole weight
				maxProfit+=currProf;
				capacity-=currWt;
			}else {
				//taking fraction of weights
				double fraction = (double)capacity/(double)currWt;
				maxProfit+=fraction*currProf;
				capacity
                = (int)(capacity - (currWt * fraction));
				break;
			}
		}
		return maxProfit;
	}
}

class ItemDetail{
	int wt;
	int prof;
	Double ppw;//profit per weight
	public ItemDetail(int wt, int prof) {
		this.wt=wt;
		this.prof=prof;
		this.ppw = new Double((double)prof/(double)wt);
	}
}