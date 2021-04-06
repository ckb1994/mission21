package graph;

public class DetectCycleUsingUnioFind {
	int v,e;
	Edge[] edges;
	
	DetectCycleUsingUnioFind(int v, int e){
		this.v=v;
		this.e=e;
		edges = new Edge[e];
		
		for(int i=0;i<e;i++) {
			edges[i] = new Edge();
		}
	}

	//find the parent
	int find(int[] parent, int i) {
		if(parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}
	
	//union - to stablish relation
	void union(int[] parent , int x, int y) {
		parent[x] = y;
	}
	
	int isCycle(DetectCycleUsingUnioFind graph) {
		int[] parent = new int[graph.v];
		
		for(int i=0;i<graph.v;i++) {
			parent[i]=-1;
		}
		
		for(int i=0;i<graph.e;i++) {
			int x = graph.find(parent, graph.edges[i].src);
			int y = graph.find(parent, graph.edges[i].dest);
			
			if(x == y) {
				return 1;
			}
			graph.union(parent, x, y);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int v=3;
		int e=3;
		DetectCycleUsingUnioFind graph = new DetectCycleUsingUnioFind(v, e);
		graph.edges[0].src = 0;
		graph.edges[0].dest = 1;
		
		graph.edges[1].src = 1;
		graph.edges[1].dest = 2;
		
		graph.edges[2].src = 2;
		graph.edges[2].dest = 0;
		
		if(graph.isCycle(graph) == 1) {
			System.out.println("Cycle found");
		}else {
			System.out.println("Cycle not found");
		}
	}
	
}


class Edge{
	int src,dest;
}