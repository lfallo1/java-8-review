package com.lancefallon.generics;

public class BaseballPlayer extends Player {

	public BaseballPlayer(String name){
		super(name);
	}
	
	@Override
	public void play(){
		System.out.println(this.getName() + " playing baseball");
	}

	@Override
	public int compareTo(Player p) {
		return p.getName().compareTo(this.getName());
	}
	
}
