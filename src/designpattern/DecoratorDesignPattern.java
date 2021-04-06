package designpattern;

public class DecoratorDesignPattern {

	public static void main(String[] args) {
		Pizza mar = new Margherita();
		System.out.println(mar.getdescription() + " " + mar.getCost() + " rs.");
		
		Pizza farm = new FarmHouse();
		farm = new FreshTomto(farm);
		System.out.println(farm.getdescription() + " " + farm.getCost() + " rs.");
	
		mar = new CheezeBusrt(mar);
		System.out.println(mar.getdescription() + " " + mar.getCost() + " rs.");
		
	}
}


abstract class Pizza{
	
	public String description = "";
	public String getdescription() {
		return description;
	}
	public abstract double getCost();
}

class FarmHouse extends Pizza{

	FarmHouse(){
		this.description = "FarmHouse Pizza";
	}
	@Override
	public double getCost() {
		return 200.00;
	}
	
}

class Margherita extends Pizza{

	public Margherita() {
		this.description = "Margherita Pizza";
	}
	@Override
	public double getCost() {
		return 150.00;
	}
	
}

//Decoration abstract class
abstract class Topping extends Pizza{
	public abstract String getdescription();
}

class CheezeBusrt extends Topping{
	Pizza pizza;
	public CheezeBusrt(Pizza pizza) {
		this.description=pizza.description;
		this.pizza = pizza;
	}
	
	@Override
	public String getdescription() {
		return this.description +  " With CheezeBurst";
	}

	@Override
	public double getCost() {
		return 25.00 + pizza.getCost();
	}
	
}

class FreshTomto extends Topping{

	Pizza pizza;
	
	public FreshTomto(Pizza pizza) {
		this.pizza = pizza;
	}
	@Override
	public String getdescription() {
		return pizza.getdescription() + " With Fresh Tomoto";
	}

	@Override
	public double getCost() {
		return 15.00+ pizza.getCost();
	}
	
}