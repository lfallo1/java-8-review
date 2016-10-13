package com.lancefallon.hashequals;

import java.util.Comparator;

public class MyComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getId() > s2.getId() ? 1 : s1.getId() < s2.getId() ? -1 : 0;
	}

}
