package com.lancefallon.generics2.abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class EmployeeService<T extends Employee> {

	protected List<T> employees = new ArrayList<>();
	
	public abstract List<T> add(T t);
	
	public abstract void showHighSalaries();
	
}
