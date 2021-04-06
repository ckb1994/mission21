package multithreading;

public class SynchronizedKeywordDemo {

	
	
	public static void main(String[] args) {
		Sender sender = new Sender();
		ThreadSend t1 = new ThreadSend("Hi", sender);
		ThreadSend t2 = new ThreadSend("Hello", sender);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
		}
	}
}

class Sender{
	
	public void send(String message) {
		System.out.println("Sending : \t"+ message);
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+ " : "+ i);
		}
		try {
			System.out.println(Thread.currentThread().getName() + " is sleeping");
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " thread interrupted");
		}
		System.out.println(message + " message sent");
	}
}

class ThreadSend extends Thread{
	private String message;
	Sender sender;
	
	public ThreadSend(String message, Sender sender) {
		this.message = message;
		this.sender = sender;
	}
	public void run() {
		synchronized (sender) {
			sender.send(message);
		}
	}
}