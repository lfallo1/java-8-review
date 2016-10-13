package com.lancefallon.section8.polymorphism;

public class Vehicle {

	protected String name;
	protected String engine;
	
	public Vehicle(){
		this.name = "generic vehicle";
		this.engine = "regular";
		System.out.println("creating vehicle");
	}
	
	public Vehicle(String name, String engine){
		this.name = name;
		this.engine = engine;
	}
	
	public void drive(){
		System.out.println("driving a " + this.name + " with a " + this.engine + " engine");
	}
}
