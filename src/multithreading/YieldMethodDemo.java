package multithreading;

//yield pause process of that thread fro another thread of having same or more priority
class YieldThread extends Thread{
	@Override
	public void run() {
		System.out.println("child thread : "+ Thread.currentThread().getName() + " Run method started");
		Thread.yield();
		for(int i=0;i<500;i++) {
			System.out.println("Child Thread : "+ Thread.currentThread().getName() +  " : " + i + " Yield");
		}
		System.out.println("child thread : "+ Thread.currentThread().getName() + " Run method completed");
	}
}
public class YieldMethodDemo {

	public static void main(String[] args) {
		YieldThread t = new YieldThread();
		t.start();
		for(int i=0;i<50;i++) {
			System.out.println("Main Thread : "+ Thread.currentThread().getName() +  " : " + i);
		}
	}

}
