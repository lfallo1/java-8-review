package com.lancefallon.section8.polymorphism;

public class Car extends Vehicle {
	
	private int doors;
	
	public Car(){
		System.out.println("creating vehicle");
	}
	
	public Car(String name, String engine){
		super(name, engine);
		this.doors = 2;
	}
	
	@Override
	public void drive(){
		System.out.println("driving a car. it has a " + this.engine + " engine and " + this.doors + " doors");
	}
}
