package dynamicprogram;

// find shortest path from src to sink where multiple nodes are given per stage
// need to choose any optiomal node from each stage

public class MultiStageGraph {

	public static void main(String[] args) {
		int stage = 4; // 4 address
		int n = 8;// 8 nodes

		int[][] c = {
				{0,0,0,0,0,0,0,0,0},
				{0,0,2,1,3,0,0,0,0},
				{0,0,0,0,0,2,3,0,0},
				{0,0,0,0,0,6,7,0,0},
				{0,0,0,0,0,6,8,9,0},
				{0,0,0,0,0,0,0,0,6},
				{0,0,0,0,0,0,0,0,4},
				{0,0,0,0,0,0,0,0,5},
				{0,0,0,0,0,0,0,0,0}
		};

		MultiStageGraph graph = new MultiStageGraph();
		graph.solveMultiStage(c, n, stage);
	}

	private void solveMultiStage(int[][] graph, int nodes, int stage) {
		int min; 
		int[] cost = new int[nodes+1];
		int[] viaNode = new int[nodes+1];
		int[] path = new int[stage+1];// src + one node each stage

		// starting from back side so that get optimal cost from each node
		// then will take decisions from front after getting optimal costs for each node
		cost[nodes] = 0; // here nodes means last node and it is 8 in current input
		for(int i = nodes -1 ; i>0 ; i--) {
			min = Integer.MAX_VALUE;

			// taking i as node and calculating its cost towards sink
			for(int k=i+1;k<=nodes;k++){
				if(graph[i][k] != 0 && graph[i][k] + cost[k] < min) {
					min = graph[i][k] +  cost[k];
					viaNode[i] = k;
				}
			}
			cost[i] = min;
		}
		//cost and via Path for every node is calculated
		
		//Now Will get the path
		//Real DP starts from here
		path[1] = 1;
		path[stage] = nodes;
		for(int i = 2; i< stage ; i++) {
			path[i] = viaNode[path[i-1]];
		}
		System.out.println("Cost of SRC to Dest : "+ cost[1]);
		printShortestPath(path);
	}

	private void printShortestPath(int[] path) {
		int len = path.length;
		System.out.print("Shortest path from SRC to DEST ");
		for(int i =1;i<len;i++) {
			System.out.print(path[i] + " ");
		}
	}
}
