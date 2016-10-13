package com.lancefallon.generics2.abstracts;

public abstract class Employee implements Comparable<Employee> {

	private final String name;
	private final String position;
	private final Double salary;
	
	{
		System.out.println("Creating a new employee...");
	}

	public Employee(String name, String position, Double salary) {
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public Double getSalary() {
		return salary;
	}
	
	public abstract void printDetails();
	
	@Override
	public int compareTo(Employee e) {
		return e.getName().compareTo(this.getName());
	}

}
