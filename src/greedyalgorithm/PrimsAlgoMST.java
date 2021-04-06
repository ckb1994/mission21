package greedyalgorithm;

public class PrimsAlgoMST {
	int virtex = 5;
	
	public static void main(String[] args) {
		PrimsAlgoMST prims = new PrimsAlgoMST();
		
		int[][] graph = new int[][] {{0,2,0,6,0},
									 {2,0,3,8,5},
									 {0,3,0,0,7},
									 {6,8,0,0,9},
									 {0,5,7,9,0}}; 
		prims.primsMst(graph);
	}

	private void primsMst(int[][] graph) {
		int[] parent = new int[virtex];
		int[] weight = new int[virtex];
		boolean[] visited = new boolean[virtex];
		for(int i= 0; i<virtex; i++) {
			visited[i] = false;
			weight[i] = Integer.MAX_VALUE;
		}
		
		// start from 0
		weight[0] = 0;
		parent[0] = -1;// it is parent of itself
		
		// considered 0 already so only virtex-1 notes are remaining
		for(int count = 0; count < virtex-1 ; count++) {
			int u = minWt(weight, visited);
			visited[u] = true;
			
			// now using node at index u, check all other nore including this node also
			for(int v=0;v<virtex;v++) {
				if(graph[u][v] !=0 && visited[v] == false && graph[u][v] < weight[v]) {
					parent[v] = u;
					weight[v] = graph[u][v];
				}
			}
			
		}
		printMst(graph, parent);
	}

	private void printMst(int[][] graph, int[] parent) {
		System.out.println("Edge \tWeight");
		int sum=0;
        for (int i = 1; i < virtex; i++) {
        	System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        	sum+=graph[i][parent[i]];
        }
        System.out.println("Total weight : "+ sum);
	}

	private int minWt(int[] weight, boolean[] visited) {
		int min, min_ind;
		min = Integer.MAX_VALUE;
		min_ind = -1;
		for(int i=0;i<virtex;i++) {
			if(visited[i] == false && weight[i]< min) {
				min = weight[i];
				min_ind = i;
			}
		}
		return min_ind;
	}
}