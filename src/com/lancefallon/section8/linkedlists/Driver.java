package com.lancefallon.section8.linkedlists;

import java.util.LinkedList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Customer> list = new LinkedList<>();
		list.add(new Customer("lance", 50.0));
		list.add(new Customer("bill", 100.0));
		list.add(new Customer("harry", 75.0));

//		Collections.sort(list, (Customer c1, Customer c2)-> c1.getName().compareTo(c2.getName()));
		
		for(int i = 0; i < 1000000; i++){
			list.add(new Customer("cust" + i, 50.0 + i));
		}
		
		long t = System.nanoTime();
		for(int i = list.size()-1; i >= 0; i--){
			list.remove(i);
//			if(list.get(i).getName().contains("cust9990")){
//				System.out.println("found!");
//				System.out.println(list.get(i).getName());
//				long insertionStart = System.nanoTime();
//				list.add(i++, new Customer("NEW CUSTOMER", 89.0));
//				System.out.println("insertion duration: " + (System.nanoTime()  - insertionStart));
//			}
//			System.out.println(i);
		}
		System.out.println("duration: " + (System.nanoTime()  - t));
	}

}
