package greedyalgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
// it uses optimal merge pattern
public class HuffManCoding {

	public static void main(String[] args) {
		int n=0;
		char[] arr = {'a','b','c','d','e','f'};
		int[] freq = {5,9,12,13,16,45};
		if(arr.length == freq.length) {
			 n =arr.length;
		}else {
			System.out.println("Array arr and freq are not having same number of records");
			return;
		}
//		char[] arr = {'a'};
//		int[] freq = {5};
		if(n==1) {
			System.out.println(arr[0]+" : "+"0");
			return;
		}
			
		PriorityQueue<HuffManNode> q = new PriorityQueue<>(n, new MyComparator());
		for(int i=0;i<n;i++) {
			HuffManNode hn = new HuffManNode(arr[i], freq[i]);
			q.add(hn);
			hn=null;
		}
		
		HuffManNode root = null;
		
		while(q.size()>1) {
			HuffManNode x = q.poll();
			HuffManNode y = q.poll();
			HuffManNode f = new HuffManNode('-', x.freq + y.freq);
			f.left = x;
			f.right = y;
			
			root = f;
			q.add(f);
		}
		printCode(root, "");
	}

	private static void printCode(HuffManNode root, String code) {
		// if char is not isLetter
		
		if(root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c+" : "+code);
			return;
		}
		printCode(root.left, code+"0");
		printCode(root.right, code+"1");
		
		
	}
	
}

class MyComparator implements Comparator<HuffManNode>{
	@Override
	public int compare(HuffManNode o1, HuffManNode o2) {
		return o1.freq - o2.freq;
	}
}

class HuffManNode{
	char c;
	int freq;
	HuffManNode left, right;
	HuffManNode(char c, int freq){
		this.c = c;
		this.freq = freq;
		this.left = null;
		this.right = null;
	}
}