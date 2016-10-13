package com.lancefallon.section8.inheritance;

public class Car extends Vehicle {

	public Car(){
		this.drivingMessage = "I am a driving a car!!";
	}
	
	public void drive(){
		System.out.println("CAR- " + this.drivingMessage);
	}
	
}
