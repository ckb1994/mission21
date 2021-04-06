package greedyalgorithm;

// single source shortest path
// valid for non negative weights 
// wt 0 means there is no path
public class DijkshtraAlgo {

	static final int virtex = 9;
	
	public static void main(String[] str) {
		DijkshtraAlgo dj = new DijkshtraAlgo();

		int[][] graph = new int[][] {
			{0,4,0,0,0,0,0,8,0},
			{4,0,8,0,0,0,0,11,0},
			{0,8,0,7,0,4,0,0,2},
			{0,0,7,0,9,14,0,0,0},
			{0,0,0,9,0,10,0,0,0},
			{0,0,4,14,10,0,2,0,0},
			{0,0,0,0,0,2,0,1,6},
			{8,11,0,0,0,0,1,0,7},
			{0,0,2,0,0,0,6,7,0}
		};
		
		dj.solveDijkshtra(graph, 0);// 0 is taken as src
	}

	private void solveDijkshtra(int[][] graph, int src) {
		boolean[] visited = new boolean[virtex];
		int[] dist = new int[virtex];
		
		for(int i=0;i<virtex;i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		dist[src] = 0;
		// src is selected so only needs to run for all nodes except src one.
		for(int count = 0; count<virtex-1;count++) {
			int u = minDist(visited, dist);
			visited[u] = true;
			// now move to all node in gragh array
			for(int v =0;v<virtex;v++) {
				if(visited[v] == false && graph[u][v] !=0 && 
						dist[u] != Integer.MAX_VALUE && 
						dist[u]+graph[u][v] < dist[v]){
					dist[v] =  dist[u] + graph[u][v];
				}
				}
		}
		printSingleSourceShortestPath(dist);
	}
	
	private void printSingleSourceShortestPath(int[] dist) {
		System.out.println("Virtex \t\t Distance from src");
		int totalDistance = 0;
		for(int i=0;i<virtex;i++) {
			System.out.println(i+" \t\t "+ dist[i]);
			totalDistance+=dist[i];
		}
		System.out.println();
		System.out.println("Min distance for covering all nodes from src is : "+ totalDistance
				);
	}

	private int minDist(boolean[] visited, int[] dist) {
		int min = Integer.MAX_VALUE;
		int minInd = -1;
		
		for(int i=0;i<virtex;i++) {
			if(visited[i] == false && dist[i]<min) {
				min = dist[i];
				minInd = i;
			}
		}
		
		return minInd;
		
	}
}
