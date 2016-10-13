package com.lancefallon.generics3;

public class CokeGlass<T extends Coke>{
	
	private T t;
	
	public CokeGlass(T t){
		this.t = t;
	}
	
	public void showSoda(){
		System.out.println(t.toString());
	}

	public T getT(){
		return t;
	}
	
}
