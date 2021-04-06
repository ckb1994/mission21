package dynamicprogram;

public class TravelingSalesmanHeldKarp {

	int vertices = 4,max = 999999;
	int visitedAll = (1<<vertices) -1;
	int[][] dist;
	int[][] dp;
	public TravelingSalesmanHeldKarp() {
		dp= new int[vertices*vertices][vertices];
		for(int i=0;i< vertices*vertices ;i++)
			for(int j=0;j<vertices;j++)
				dp[i][j] = -1;
	}
	
	public static void main(String[] args) {
		TravelingSalesmanHeldKarp tsp = new TravelingSalesmanHeldKarp();
		tsp.dist = new int[][]{
			{0,10,15,20},
			{5,0,9,10},
			{6,13,0,12},
			{8,8,9,0}
		};
		
		System.out.println("Travelling Saleman Distance is "+ tsp.tsp(1,0));
		tsp.print(tsp.dp);

	}

	private int tsp(int mask, int pos) {
		if(mask == visitedAll)
			return dist[pos][0];
		if(dp[mask][pos] != -1)
			return dp[mask][pos];
		
		int ans = max;
		for(int node = 0; node < vertices ;node++) {
			if((mask&(1<<node))== 0) {
				int newAns = dist[pos][node] + tsp(mask|(1<<node), node);
				ans = Math.min(ans, newAns);
			}
		}
		dp[mask][pos] = ans;
		return dp[mask][pos];
	}

	private void print(int[][] dp) {
		System.out.println("***********Start*************");
		int r = dp.length;
		int c = dp[0].length;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("***********End*************");
	}
}
