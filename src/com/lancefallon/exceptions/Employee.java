package com.lancefallon.exceptions;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable {

	private static final long serialVersionUID = -4359833265823705435L;

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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", position=" + position + ", salary=" + String.format("$%.02f", salary) + "]";
	}

	@Override
	public int compareTo(Employee e) {
		if(e.getSalary() > this.getSalary()){
			return 1;
		} else if(e.getSalary() < this.getSalary()){
			return -1;
		}
		return 0;
	}

}
