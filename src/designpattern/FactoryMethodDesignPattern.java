package designpattern;

import java.util.Scanner;

public class FactoryMethodDesignPattern {

	
	
	public static void main(String[] args) {
		System.out.println("Enter Car Type : ");
		Scanner sc = new Scanner(System.in);
		String carType = sc.nextLine();
		sc.close();
		CarFactory carFac = new CarFactory();
		carFac.manufactorCar(carType.toLowerCase());
	}

}


abstract class Car{
	
	public abstract void addEngineType();
	
	public void deliverCar() {
		System.out.println("Car will be delivered soon to your doorStep");
	}
}

class AudiCar extends Car{

	@Override
	public void addEngineType() {
		System.out.println("Gasolin Engine");
	}
}

class TeslaCar extends Car{

	@Override
	public void addEngineType() {
		System.out.println("Electric Engine");
	}
}

class CarFactory{
	public Car manufactorCar(String carType) {
		Car car;
		switch (carType.toLowerCase()) {
		case "audi":
			car = new AudiCar();
			break;
		case "tesla":
			car = new TeslaCar();
			break;
		default:
			throw new IllegalArgumentException("Wrong Car type selected");
		}
		car.addEngineType();
		car.deliverCar();
		return car;
	}
}