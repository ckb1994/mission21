package dynamicprogram;

class Edge{
	int src,dest,weight;
	public Edge() {
		src=dest=weight=0;
	}
}
public class BellManFord {

	int V,E;
	Edge[] edge;
	public BellManFord(int v, int e) {
		 this.V=v;
		 this.E=e;
		 edge = new Edge[E];
		 for(int i=0;i<E;i++) {
			 edge[i] = new Edge();
		 }
	}
	public static void main(String[] args) {
		int v=5,e=8;
		BellManFord graph = new BellManFord(v, e);

		// add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
  
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
  
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
  
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
  
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
  
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
  
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
  
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
        
        //calling BellManFord
        graph.solveBellMan(graph, 0);
	}
	private void solveBellMan(BellManFord graph, int src) {
		int v = graph.V;
		int e = graph.E;
		
		int[] dist = new int[v];
		for(int i=0;i<v;i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src]=0;
		//start relaxing all edges v-1 times
		for(int i=1;i<v;i++) {
			// for every edges
			for(int j=0;j<e;j++) {
				int s = graph.edge[j].src;
				int d = graph.edge[j].dest;
				int wt =graph.edge[j].weight;
				
				if(dist[s]!= Integer.MAX_VALUE && dist[s]+ wt < dist[d])
					dist[d] = dist[s] + wt;
			}
		}
		
		//// checking for negative weight cycle
		for(int j=0;j<e;j++) {
			int s = graph.edge[j].src;
			int d = graph.edge[j].dest;
			int wt =graph.edge[j].weight;
			
			if(dist[s]!= Integer.MAX_VALUE && dist[s]+ wt < dist[d])
				System.out.println("Found negative weighted cycle");
		}
		printBellManFord(dist,v);
	}
	private void printBellManFord(int[] dist, int v) {
		System.out.println("Vertex \t\t Distance from src");
		for(int i=0;i<v;i++)
			System.out.println(i + " \t\t "+ dist[i]);
	}

}
