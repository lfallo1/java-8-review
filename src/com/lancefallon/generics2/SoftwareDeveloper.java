package com.lancefallon.generics2;

import java.util.Arrays;
import java.util.List;

import com.lancefallon.generics2.abstracts.Employee;

public class SoftwareDeveloper extends Employee implements Developer {

	public SoftwareDeveloper(String name, String position, Double salary) {
		super(name, position, salary);
	}
	
	@Override
	public void printDetails() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString(){
		return "Software dev: " + this.getName() + ": " + this.getPosition() + " ($" + this.getSalary() + ")";
	}

	@Override
	public List<String> programmingLanguages() {
		return Arrays.asList("Java", "SQL", "C#", "Javascript");
	}

}
