package com.lancefallon.section8.linkedlists;

import java.util.LinkedList;

public class Driver {

	public static void main(String[] args) {
		LinkedList<Customer> list = new LinkedList<>();
		list.add(new Customer("lance", 50.0));
		list.add(new Customer("bill", 100.0));

	}

}
