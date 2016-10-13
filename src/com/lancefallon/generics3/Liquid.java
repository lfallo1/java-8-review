package com.lancefallon.generics3;

public abstract class Liquid {

	protected String name;
	protected Double density;
	protected String color;

	public Liquid(String name, Double density, String color) {
		this.name = name;
		this.density = density;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public Double getDensity() {
		return density;
	}

	public String getColor() {
		return color;
	}

	public abstract void pourDrink();

}
