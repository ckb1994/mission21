package greedyalgorithm;
import java.util.Arrays;

public class KrushkalsAlgorithm {

	int v,e;
	Edge[] edges;
	 public KrushkalsAlgorithm(int v, int e) {
		 this.v = v;
		 this.e = e;
		 edges = new Edge[e];
		 for(int i=0;i<e;i++) {
			 edges[i] = new Edge();
		 }
	 }
	 
	 public static void main(String[] args) {
		int v = 4;
		int e = 5;
		KrushkalsAlgorithm graph = new KrushkalsAlgorithm(v, e);
		
		graph.edges[0].src = 0;
		graph.edges[0].dest = 3;
		graph.edges[0].wt = 5;
		
		graph.edges[1].src = 0;
		graph.edges[1].dest = 2;
		graph.edges[1].wt = 6;
		
		graph.edges[2].src = 2;
		graph.edges[2].dest = 3;
		graph.edges[2].wt = 4;
		
		graph.edges[3].src = 0;
		graph.edges[3].dest = 1;
		graph.edges[3].wt = 10;
		
		graph.edges[4].src = 1;
		graph.edges[4].dest = 3;
		graph.edges[4].wt = 15;
		
		graph.KrushkalAlgo();
	}

	private int findParent(Subset[] subset, int i) {
		if(subset[i].parent != i) {
			subset[i].parent = findParent(subset, subset[i].parent);
		}
		
		return subset[i].parent;
	}
	 
	
	private void UnionNodes(Subset[] subsets, int x, int y) {
		int xPar = findParent(subsets, x);
		int yPar = findParent(subsets, y);
		
		if(subsets[xPar].rank < subsets[yPar].rank) {
			subsets[xPar].parent = yPar;
		}else if(subsets[xPar].rank > subsets[yPar].rank) {
			subsets[yPar].parent = xPar;
		}else {
			subsets[yPar].parent = xPar;
			subsets[xPar].rank++;
		}
	}
	private void KrushkalAlgo() {
		Edge[] result = new Edge[v];
		for(int i=0;i<v;i++)
			result[i] = new Edge();
		Arrays.sort(edges);
		Subset[] subsets = new Subset[v];
		for(int i=0;i<v;i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		int j=0;
		int edgeCount =0;
		while(edgeCount < v-1) {
			Edge edgeNext = edges[j++];
			int x = findParent(subsets, edgeNext.src);
			int y = findParent(subsets, edgeNext.dest);
			if(x!=y) {
				result[edgeCount++] = edgeNext;
				UnionNodes(subsets, x, y);
			}
		}
		
		int weightCount =0;
		for(int i=0;i<edgeCount;i++) {
			weightCount+=result[i].wt;
			System.out.println(result[i].src + " ---> " + result[i].dest + " == "+ result[i].wt);
		}
		System.out.println("Total cost : "+weightCount);
	}
}


class Edge implements Comparable<Edge>{
	
	int src, dest, wt;
	
	@Override
	public int compareTo(Edge o) {
		return this.wt - o.wt;
	}
}


class Subset{
	int parent, rank;
}