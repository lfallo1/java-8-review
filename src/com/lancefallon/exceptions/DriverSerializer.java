package com.lancefallon.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DriverSerializer {

	private static final Comparator<Employee> EMPLOYEE_SORT_SALARY;
	private static final Comparator<Employee> EMPLOYEE_SORT_NAME_DESC;
	
	static{
		EMPLOYEE_SORT_SALARY = (Employee e1, Employee e2) -> e1.getSalary() > e2.getSalary() ? 1 : e1.getSalary() < e2.getSalary() ? -1 : 0;
		EMPLOYEE_SORT_NAME_DESC = (Employee e1, Employee e2) -> e2.getName().compareTo(e1.getName());
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(new FileReader("/"));
		s.close();
		String path = "/Users/lancefallon/Desktop/EmployeeService.lance";
		try{
//			serialize(path);
			deserialize(path);
		} catch(ClassNotFoundException | IOException e){
			System.out.println(e.toString());
		}
	}
	
	public static void deserialize(String path) throws ClassNotFoundException, IOException, FileNotFoundException{
		try(FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			LinkedList<Employee> employees = DriverSerializer.<LinkedList<Employee>>readObject(ois);
			Collections.sort(employees, EMPLOYEE_SORT_SALARY);
			employees.stream()
				.filter(e->e.getSalary() > 100000)
				.forEach(e->System.out.println(e.toString()));
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static<T> T readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		return (T)ois.readObject();
	}
	
	public static void serialize(String path) throws IOException, FileNotFoundException{
		
		List<Employee> list = new LinkedList<>();
		for(int i = 0; i < 1000; i++){
			list.add(new Employee("emp" + i, "dev" + (i % 5), 35000.0 + new Random().nextDouble()*75000.0));
		}
		try(FileOutputStream fout = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fout)){
			oos.writeObject(list);
		}
	}
	
}
