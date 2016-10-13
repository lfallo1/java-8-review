package com.lancefallon.generics;

public class Driver {

	public static void main(String[] args) {

		Team<BaseballPlayer> orioles = new Team<>();
		orioles.addPlayer(new BaseballPlayer("bill"));
		orioles.addPlayer(new BaseballPlayer("joe"));
		orioles.addPlayer(new BaseballPlayer("lance"));

		orioles.displayPlayers();
	}

}
