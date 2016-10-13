package com.lancefallon.generics3;

public class OrangeJuice extends Liquid {

	public OrangeJuice(String name, Double density, String color) {
		super(name, density, color);
	}

	@Override
	public void pourDrink() {
		System.out.println("Pouring " + this.name);
	}

}
