	package com.lancefallon.hashequals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Driver {
	
	public static final Comparator<Student> ID_ASCENDING;
	
	static {
		ID_ASCENDING = (Student s1, Student s2) -> s1.getId() > s2.getId() ? 1 : s1.getId() < s2.getId() ? -1 : 0; 
	}

	public static void main(String[] args) throws InterruptedException {
//		Student s1 = new Student1, "lance");
//		Student s2 = new Student(2, "kara");
//		Student s3 = new Student(3, "laura");
		
		Random r = new Random();
		
		/**
		 * HashMap example
		 */
		System.out.println("\r\n\r\bHashMap Example");
		Map<Student, ReportCard> reports = new HashMap<>();
		for(int i = 0; i < 1000; i++){
			int n1 = r.nextInt()*100;
			int n2 = r.nextInt()*100;
			int n3 = r.nextInt()*100;
			reports.put(new Student(i, "student" + i), new ReportCard(n1,n2,n3)); 
		}
		System.out.println(reports.size());
		long start = System.nanoTime();
		System.out.println(reports.containsKey(new Student(200, "dont matter")));
		System.out.println("elapsed: " + (System.nanoTime() - start));
		
		/**
		 * HashSet example
		 */
		System.out.println("\r\n\r\bHashSet Example");
		Set<Student> students = new TreeSet<>();
		students.add(new Student(100, "student100"));
		for(int i = 0; i < 100; i++){
			students.add(new Student(i, "student" + i));
		}
		
		System.out.println(students.size());
		start = System.nanoTime();
		System.out.println(students.contains(new Student(200, "dont matter")));
		System.out.println("elapsed: " + (System.nanoTime() - start));
		
		System.out.println(new Student(200, "dont matter") == new Student(200, "dont bother")); //false
		System.out.println(new Student(200, "dont matter").equals(new Student(200, "dont bother"))); //true
		
		/**
		 * ArrayList - implemented as resizeable array. As more elements are added to ArrayList, its size is increased dynamically. It's elements can be accessed directly by using the get and set methods, since ArrayList is essentially an array
		 * Vector - thread-safe version of array list (requires more memory)
		 * LinkedList - implemented as doubly linked list. faster for insertions and deletions, then ArrayList/Vector. slow for get/set operations.
		 * 
		 * HashSet -- unordered, no dups
		 * LinkedHashSet -- ordered by insertion, no dups
		 * TreeSet -- ordered by sorting criterea, no dups
		 * 
		 * HashMap - k/v, no dups by key (according to hashcode & equals), order not guaranteed
		 * HashTable - ike hashmap, but synchronous (overhead, only use if not threadsafe)
		 * LinkedHashMap - k/v, no dups by key, insertion order preserved
		 * TreeMap - k/v, no dups by key, sorted (key object must be sortable, or implement comparable)
		 * 
		 * Comparable - the interface a class must implement if it wishes to define its own sorting
		 * Comparator - A class that can be used to sort an object. the object being sorted does not need to define its own sorting
		 * 		can be defined in its own class or as an anonymous class (either in line or even declared as a constant)
		 */
		System.out.println("\r\n\r\bSet printout");
		
//		Collections.sort(students, new MyComparator()); //same as above, but defining own class that implements comparator
//		Collections.sort(students, Driver.ID_ASCENDING);
		for(Student s : students){
			System.out.println(s.toString());
		}
	}

}
