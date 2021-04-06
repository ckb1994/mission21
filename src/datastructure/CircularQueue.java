package datastructure;

public class CircularQueue {

	int rear,front,capacity;
	int[] arr;
	public CircularQueue(int capacity) {
		this.front =  this.rear = -1;
		this.capacity = capacity;
		arr = new int[capacity];
	}
	
	//isFull
	boolean isFull() {
		if(front == 0 && rear == capacity -1) {
			return true;
		}
		if(front == rear+1) {
			return true;
		}
		return false;
	}
	//isEmpty
	boolean isEmpty() {
		return front == -1;
	}
	//enqueue
	void enQueue(int element) {
		if(isFull()) {
			System.out.println("Circular Queue is full. Front : "+ front + " Rear : "+ rear);
			System.exit(1);
		}
		if(front == -1)
			front++;
		rear = (rear+1)%capacity;
		arr[rear]=element;
		System.out.println(element + " Inserted into Circular Queue at index : " + rear);
	}
	//dequeuq
	int deQueue() {
		int element;
		if(isEmpty()) {
			System.out.println("Queue is empty");
			System.exit(1);
		}
		element = arr[front];
		System.out.println("Element "+ element + " dequeue from index : "+ front);
		if(front == rear)
		{
			front = rear = -1;
		}else{
			front = (front+1)%capacity;
		}
		return element;
	}
	//print
	void printCircularQueue() {
		int i;
		System.out.println();
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
			System.out.println("Items are from index : "+ front + " to index: "+ rear);
			for(i=front; i!= rear ;) {
				System.out.print(arr[i]+" ");
				i = (i+1)%capacity;
			}
			System.out.println(arr[i]+" ");
		}
	}
	//main
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(5);
		cq.enQueue(1);
		cq.enQueue(2);
		cq.enQueue(3);
		cq.enQueue(4);
		cq.enQueue(5);
		cq.printCircularQueue();
		cq.deQueue();
		cq.printCircularQueue();
		cq.enQueue(6);
		cq.printCircularQueue();
		cq.deQueue();
		cq.deQueue();
		cq.deQueue();
		cq.deQueue();
		cq.printCircularQueue();
	}
}
