package com.lancefallon.generics2;

import com.lancefallon.generics2.abstracts.EmployeeService;

public class Driver {

	public static void main(String[] args) {
		
		SoftwareDeveloper dev1 = new SoftwareDeveloper("lance", "dev2", 60000.0);
		SoftwareDeveloper dev2 = new SoftwareDeveloper("bob", "dev2", 70000.0);
		SoftwareDeveloper dev3 = new SoftwareDeveloper("tim", "dev1", 50000.0);
		EmployeeService<SoftwareDeveloper> service = new EmployeeServiceImpl<>();
		service.add(dev1);
		service.add(dev2);
		service.add(dev3);
		System.out.println("added new emp. programming langs are: " + service.add(dev3).get(2).programmingLanguages());
		
		System.out.println("\r\nprinting list...");
		service.showHighSalaries();
		
		/**
		 * following gives error if EmployeeService bound parameters are T extends Employee & Developer:
		 * EmployeeService<HumanResources> hr = new EmployeeService<>();
		 */ 
	}

}
