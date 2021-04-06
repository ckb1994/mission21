package datastructure;

public class QueueDemo {

	int[] arr;
	int front, rear, capacity;
	public QueueDemo(int capacity) {
		front=rear=-1;
		this.capacity = capacity;
		arr = new int[capacity];
	}
	
	//isEmpty
	boolean isEmpty() {
		return front ==-1;
	}
	
	//isFull
	boolean isFull() {
		return (rear == capacity-1);
	}
	
	//enqueue
	void enqueue(int element) {
		if(isFull()) {
			System.out.println("Queue is Full, So Can't enqueue "+ element);
			System.exit(1);
		}else {
			if(front ==-1) {
				front =0;
			}
			arr[++rear]=element;
			System.out.println("Inserted : "+ element);
		}
	}
	
	//dequeue
	int dequeue() {
		int element ;
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			System.exit(1);
		}
		element = arr[front];
		if(front>=rear) {
			front = rear = -1;
		}else {
			front++;
		}
		System.out.println("Deleted : "+element);

		return element;
	}
	
	// print
	void printQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}
		else {
			System.out.println("Front Index : "+front);
			System.out.print("Items are : ");
			for(int i= front;i<=rear;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("Rear Index : "+rear);
		}
	}
	public static void main(String[] args) {
		QueueDemo queue = new QueueDemo(6);
		queue.enqueue(1);queue.enqueue(2);queue.enqueue(3);queue.enqueue(4);queue.enqueue(5);
		
		queue.printQueue();
		
		queue.dequeue();
		queue.printQueue();
		
		queue.enqueue(6);
		queue.printQueue();
		
		queue.enqueue(7);
	}

}
