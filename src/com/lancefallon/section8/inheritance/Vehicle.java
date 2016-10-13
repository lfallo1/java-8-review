package com.lancefallon.section8.inheritance;

public class Vehicle {

	protected String drivingMessage;
	
	public Vehicle(){
		this.drivingMessage = "I am driving a generic vehicle";
	}
	
	public void drive(){
		System.out.println("VEHICLE- " + drivingMessage);
	}
	
}
