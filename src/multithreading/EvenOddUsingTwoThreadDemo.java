package multithreading;

public class EvenOddUsingTwoThreadDemo {
	  
    // Starting counter
    int counter = 1;
  
    static int N;
  
    // Function to print odd numbers
    public void printOddNumber()
    {
    	synchronized (this) {
			while(counter<N) {
				while(counter%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(counter + " ");
				counter++;
				notify();
			}
		}
    }
  
    // Function to print even numbers
    public void printEvenNumber()
    {
    	synchronized (this) {
			while(counter<N) {
				while(counter%2 ==1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(counter + " ");
				counter++;
				notify();
			}
		}
    }
  
    // Driver Code
    public static void main(String[] args)
    {
    	N = 10;
    	EvenOddUsingTwoThreadDemo instance = new EvenOddUsingTwoThreadDemo();
    	Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				instance.printEvenNumber();
				
			}
		});
    	
    	Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				instance.printOddNumber();
				
			}
		});
    	
    	t1.start();
    	t2.start();
    }
}