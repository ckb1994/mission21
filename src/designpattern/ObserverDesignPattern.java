package designpattern;

import java.util.ArrayList;

public class ObserverDesignPattern {

	public static void main(String[] args) {
		Channel channel = new Channel("lets Learn");
		User u1 = new User("chandan");
		User u2 = new User("Bhavana");
		
		channel.subscribe(u1);
		channel.subscribe(u2);
		
		channel.videoUpload("Factory design pattern");
	}
}

interface Observer{
	public void update(String message);
}
interface Subject{
	public void subscribe(Observer obs);
	public void unsubscribe(Observer obs);
	public void notifyAllObserver(String message);
	
}

class User implements Observer{

	private String userName;
	
	User(String userName){
		this.userName = userName;
	}
	@Override
	public void update(String message) {
		System.out.println("Hey, "+userName + " checkout the new video : "+ message);
	}
	
}

class Channel implements Subject{

	private ArrayList<Observer> list = new ArrayList<Observer>();
	
	String channelName;
	public Channel(String channelName) {
		this.channelName = channelName;
	}
	
	@Override
	public void subscribe(Observer obs) {
		list.add(obs);
	}

	@Override
	public void unsubscribe(Observer obs) {
		list.remove(obs);
	}

	@Override
	public void notifyAllObserver(String message) {
		for(Observer obs : list) {
			obs.update(message);
		}
	}
	
	public void videoUpload(String message) {
		//After uploading video to channel, notify all subscriber
		notifyAllObserver(message);
	}
	
}