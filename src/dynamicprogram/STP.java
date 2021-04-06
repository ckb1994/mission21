package dynamicprogram;

public class STP {

	int n = 4;
	int INT_MAX = 999999;
	int[][] dist;

	int VISITED_ALL = (1<<n) -1;// total options
	
	// mask - set of city visited over so far mask = 01101, 0 is not visited
	// pos = current city position from which city, going to nxt city, 
	int  tsp(int mask,int pos){

		int[][] dp = new int[n*n][n];
		
		for(int i=0;i<(1<<n);i++){
			for(int j=0;j<n;j++){
				dp[i][j] = -1;
			}
		}
		
		//if visited all city
		if(mask==VISITED_ALL){
			return dist[pos][0];
		}
		if(dp[mask][pos]!=-1){
			return dp[mask][pos];
		}

		//Now from current node, we will try to go to every other node and take the min ans
		int ans = INT_MAX;

		//Visit all the unvisited cities and take the best route
		for(int city=0;city<n;city++){

			if((mask&(1<<city))==0){// checking current city is visited or not
				// suppose for 2nd city
				// mask = 0110 
				//mask &(1<<city) = 0110 & 0100 = 1 (already visited)

				System.out.println(mask+ " : "+ pos);
				//pos = current city, city = new city 
				int newAns = dist[pos][city] + tsp( mask|(1<<city), city);
				ans = Math.min(ans, newAns);
			}

		}

		return dp[mask][pos] = ans;
	} 

	public static void main(String[] args) {

		STP stp = new STP();
		stp.dist = new int[][]{
			{0,10,15,20},
			{5,0,9,10},
			{6,13,0,12},
			{8,8,9,0}
		};
		
		System.out.println("Travelling Saleman Distance is "+ stp.tsp(1,0));

	}
}
