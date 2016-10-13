package com.lancefallon.generics;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> {

	private List<T> players = new ArrayList<>();
	
	public void displayPlayers(){
		for(Player p : players){
			p.play();
		}
		
		
		List<String> s = new ArrayList<>();
	}

	public void addPlayer(T player){
		this.players.add(player);
	}
	
	public List<T> getPlayers() {
		return players;
	}
	
}
