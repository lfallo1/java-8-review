package com.lancefallon.section8.inheritance;

public class Car extends Vehicle {

	private String name;
	
	public Car(){
		this.drivingMessage = "I am a driving a car!!";
	}
	
	public Car(String name){
		this.name = name;
	}
	
	public void drive(){
		System.out.println("CAR- " + this.drivingMessage);
	}
	
	@Override
	public int getSomeValue(){
		String name = "another name";
		System.out.println(this.name);
		return 1;
	}
	
}
