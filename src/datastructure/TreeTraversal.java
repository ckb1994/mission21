package datastructure;

public class TreeTraversal {

	class Node{
		int data;
		Node left,right;
		Node(int key){
			this.data = key;
			this.left = this.right = null;
		}
	}
	
	Node root;
	
	void preOrder(Node node) {
		if(node == null)
			return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	void postOrder(Node node) {
		
	}
	
	public static void main(String[] args) {
		
	}

}
