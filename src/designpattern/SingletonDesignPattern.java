package designpattern;

public class SingletonDesignPattern {

	private static SingletonDesignPattern singletonInstnce=null;
	
	private String msg;
	
	private SingletonDesignPattern() {
		msg = "Hello, Welcome to Singleton Design pattern";
		System.out.println("Only once it creates the object");
	}
	
	public static SingletonDesignPattern getInstance() {
		if(singletonInstnce == null)
			singletonInstnce = new SingletonDesignPattern();
		return singletonInstnce;
	}
	
	public static void main(String[] args) {
		SingletonDesignPattern sdp = SingletonDesignPattern.getInstance();
		System.out.println(sdp.msg);
		
		SingletonDesignPattern sdp1 = SingletonDesignPattern.getInstance();
		System.out.println(sdp1.msg);
	}

}
