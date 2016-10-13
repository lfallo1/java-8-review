package com.lancefallon.generics;

public class Coach implements Comparable<Coach> {

	private String title;
	
	public Coach(String title){
		this.title = title;
	}
	
	private String getTitle(){
		return this.title;
	}
	
	@Override
	public int compareTo(Coach o) {
		return this.getTitle().compareTo(o.getTitle());
	}

}
