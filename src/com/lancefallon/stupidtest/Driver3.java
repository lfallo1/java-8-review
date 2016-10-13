package com.lancefallon.stupidtest;

public class Driver3 {
	
	private int data;
	
	public Driver3(){
		this(10);
	}
	
	public Driver3(int data){
		this.data = data;
	}
	
	public void display(){
		class Decrementor{
			public void decrement(){
				data--;
			}
		}
		Decrementor d = new Decrementor();
		d.decrement();
		System.out.println("data = " + data);
	}
	
	public static void main(String args[]){
		int data = 0;
		Driver3 d = new Driver3();
		d.display();
		System.out.println("data = " + data);
	}
}
