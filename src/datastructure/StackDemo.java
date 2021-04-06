package datastructure;

public class StackDemo {

	private int[] arr;
	int capacity;
	int top;
	
	public StackDemo(int size) {
		arr = new int[size];
		this.capacity = size;
		this.top = -1;
	}
	
	
	//
	private boolean isFull() {
		return top == (this.capacity +1);
	}
	
	//
	private boolean isEmpty() {
		return this.top == -1;
	}
	
	//
	private int size() {
		return (top+1);
	}
	
	//
	public void push(int value) {
		if(isFull()) {
			System.out.println("StackOver Flow\nProgram Terminated");
			System.exit(1);
		}
		System.out.println("Inserting : "+value);
		arr[++top] = value;
	}
	
	//
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack UnderFLow\nProgram Terminated");
			System.exit(1);
		}
		System.out.println("Poping Out : "+arr[top]);
		return arr[top--];
	}
	
	//
	public int peek(){
		if(isEmpty()) {
			System.out.println("Stack UnderFLow\nProgram Terminated");
			System.exit(1);
		}
		System.out.println("Top element : "+arr[top]);
		return arr[top];
	}

	public static void main(String[] args) {
		StackDemo stack = new StackDemo(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println("Stack Size : " + stack.size());
		stack.printStack();
		stack.pop();
		stack.printStack();
	}


	private void printStack() {
		for(int i=top;i>=0;i--) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}

}
