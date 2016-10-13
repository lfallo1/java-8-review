package com.lancefallon.section8.inheritance;

public class Driver {

	public static void main(String[] args){
		driveVehicle(new Vehicle());
		driveVehicle(new Car());
	}
	
	public static void driveVehicle(Vehicle vehicle){
		vehicle.drive();
	}
	
}
