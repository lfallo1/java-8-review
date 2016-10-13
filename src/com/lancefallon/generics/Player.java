package com.lancefallon.generics;

public abstract class Player implements Comparable<Player> {

	private String name;
	
	public Player(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public abstract void play();
	
}
