package com.lancefallon.hashequals;

public class Student implements Comparable<Student> {

	private long id;
	private String name;

	public Student(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return "id: " + this.id + ", name: " + this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student s) {
		if(s.getId() > this.getId()){
			return 1;
		} else if(s.getId() < this.getId()){
			return -1;
		}
		return 0;
	}

}
