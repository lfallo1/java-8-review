package com.lancefallon.section8.polymorphism;

public class Driver {

	public static void main(String[] args){
		Vehicle vehicle = new Vehicle("vehicle", "regular");
		Vehicle car = new Car("Honda Civic", "pathetic car");
		
		vehicle.drive();
		car.drive();
	}
	
}
