package com.lancefallon.section8.encapsulation;

public class Player extends PlayableCharacter {

	private String alias;
	private double health;
	private double maxAttack;
	private String[] moves;
	private String[] finishingMoves;
	private Boolean isGood;

	public Player() {
	}

	public Player(String alias, double maxAttack, String[] moves, String[] finishingMoves, Boolean isGood) {
		this.alias = alias;
		this.health = 100;
		this.maxAttack = maxAttack;
		this.moves = moves;
		this.finishingMoves = finishingMoves;
		this.isGood = isGood;
	}

	public Boolean attack(Player opponent) {
		double attackStrength = Math.floor(Math.random() * this.maxAttack);
		opponent.health -= attackStrength;
		System.out.println(this.alias + " " + moves[(int) Math.floor(Math.random()*moves.length)] + "\r\n" +
				"Damage inflicted "+ attackStrength +" --HEALTH SUMMARY-> " + this.alias + ": " + this.health + ", " + opponent.alias + ": " + opponent.health + "\r\n");
		if(opponent.health <= 0){
			System.out.println(finishingMoves[(int) Math.floor(Math.random()*finishingMoves.length)] + "\r\n\r\n");
			return true;
		}
		return false;
	}

	public String getAlias() {
		return alias;
	}

	public double getHealth() {
		return health;
	}

	public double getMaxAttack() {
		return maxAttack;
	}

	public String[] getFinishingMove() {
		return finishingMoves;
	}

	public Boolean getIsGood() {
		return isGood;
	}

}
