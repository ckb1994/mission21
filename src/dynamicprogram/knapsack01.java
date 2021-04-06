package dynamicprogram;


public class knapsack01 {

	public static void main(String[] args) {
		int[] profit = {0,1,2,5,6};
		int[] weight = {0,2,3,4,5};
		int bagSize = 8;
		int totalObj = 4;
		knapsack01 ks = new knapsack01();
		ks.solveKnapsack01(profit, weight, bagSize, totalObj);
	}

	private void solveKnapsack01(int[] profit, int[] weight, int bagSize, int totalObj) {
		int[][] table = new int[totalObj+1][bagSize+1];
		for(int i = 0;i<=totalObj;i++) {
			for(int j = 0;j<=bagSize; j++) {
				System.out.println(i+" : "+j);
				if(i ==0 || j ==0) {
					table[i][j]=0;
				}else if(weight[i]<=j){
					table[i][j] = Math.max(table[i-1][j], table[i-1][j-weight[i]] + profit[i]);
				}else {
					table[i][j] = table[i-1][j];
				}
			}
		}
		System.out.println("Max profit to accomodate knapsack of weight : "
		+ bagSize+" is "+table[totalObj][bagSize]);
		printknapsack(table,weight, totalObj, bagSize);
	}

	private void printknapsack(int[][] table, int[] weight, int totalObj, int bagSize) {
		int i = totalObj;
		int j = bagSize;
		while(i>0 && j >=0) {
			if(table[i][j] == table[i-1][j]) {
				System.out.println(i + " == 0");
				i--;
			}else {
				System.out.println(i + " == 1");
				j = j - weight[i];
				i--;
			}
		}
	}
}
