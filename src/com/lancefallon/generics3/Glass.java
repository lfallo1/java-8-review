package com.lancefallon.generics3;

/**
 * bound parameters must be of a type that extends Liquid
 * @author lancefallon
 *
 * @param <S>
 * @param <T>
 */
public class Glass<S extends Liquid, T extends Liquid> {

	private S liquid;
	private T liquid2;
	
	public Glass(S liquid, T liquid2){
		this.liquid = liquid;
		this.liquid2 = liquid2;
	}
	
	public void mix(){
		System.out.println("Mixing " + liquid.getName() + " with " + liquid2.getName());
		System.out.println("Density ratio: " + liquid.getName() + " / " + liquid2.getName() + String.format(" is %.02f", liquid.getDensity() / liquid2.getDensity()));
	}
	
}
