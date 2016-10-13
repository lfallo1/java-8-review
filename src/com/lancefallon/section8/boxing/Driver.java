package com.lancefallon.section8.boxing;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Integer a = 500; // Integer.valueOf(500) auto-boxing
		Integer b = 500;
		Integer c = new Integer(500);
		System.out.println(a == b); // true if between -127 and 128, otherwise false
		System.out.println(b.equals(a)); //true if values are equal
		System.out.println(a == c); //false
		System.out.println(a.equals(c)); // true if values are equal
		
		int d = a; // a.intValue(), unboxing;
		System.out.println("d: " + d);
		
		List<Double> doubleArrayList = new ArrayList<>();
		for(double doub = 0.0; doub < 10.0; doub+= 0.5){
			doubleArrayList.add(Double.valueOf(doub)); //could use auto-boxing
		}
	}

}
