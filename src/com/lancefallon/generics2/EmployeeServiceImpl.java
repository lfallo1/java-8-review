package com.lancefallon.generics2;

import java.util.List;

import com.lancefallon.generics2.abstracts.Employee;
import com.lancefallon.generics2.abstracts.EmployeeService;

public class EmployeeServiceImpl<T extends Employee> extends EmployeeService<T> {

	@Override
	public List<T> add(T t) {
		employees.add(t);
		return employees;
	}
	
	@Override
	public void showHighSalaries(){
		employees.stream()
			.filter(e->e.getSalary() >= 60000)
			.forEach(e->e.printDetails());
	}
	
}
