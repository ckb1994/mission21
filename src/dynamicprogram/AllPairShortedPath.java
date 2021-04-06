package dynamicprogram;

//Floyd Warshall
public class AllPairShortedPath {

	static final int V = 4;
	static final int INF = 9999999;// Assuming this to be infinity
	// if will tke max value  of int then it will be over flow when w add any number 
	// and it will become negative
	
	public static void main(String[] args) {
		int[][] graph = new int[][]{
			{0,0,0,0,0},
			{0,0,3,INF,7},
			{0,8,0,2,INF},
			{0,5,INF,0,1},
			{0,2,INF,INF,0}
		};
		
		AllPairShortedPath fW = new AllPairShortedPath();
		fW.printAllPairShortestPath(graph);
		fW.solveFloydWarshall(graph);
		
	}

	private void solveFloydWarshall(int[][] graph) {
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		System.out.println("Matrix is ready : Please check matrix for all pair shortest path");
		printAllPairShortestPath(graph);
	}

	private void printAllPairShortestPath(int[][] graph) {
		for(int i= 0 ; i <=V ; i++) {
			for(int j=0;j<=V;j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}

	private int min(int i, int j) {
		return i<j?i:j;
	}
}
