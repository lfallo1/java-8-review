package com.lancefallon.generics2;

import com.lancefallon.generics2.abstracts.Employee;

public class HumanResources extends Employee {

	public HumanResources(String name, String position, Double salary) {
		super(name, position, salary);
	}
	
	@Override
	public void printDetails() {
		System.out.println("HR " + this.toString());
	}

}
