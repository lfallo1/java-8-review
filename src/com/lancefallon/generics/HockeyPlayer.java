package com.lancefallon.generics;

public class HockeyPlayer extends Player {

	public HockeyPlayer(String name){
		super(name);
	}
	
	@Override
	public void play(){
		System.out.println(this.getName() + " playing hockey");
	}
	
	@Override
	public int compareTo(Player p) {
		return p.getName().compareTo(this.getName());
	}
	
}
