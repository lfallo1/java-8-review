package com.lancefallon.section8.modifiers;

import java.util.Date;

public class Accessible implements IAccessible {
	
	static final long k; //must be set in a static init block
	final long j; //must be declared either in a constructor or an instance block (cannot be set in both)
	
	//called once and only once.  is called when first instance is created, and runs before constructor.
	static {
		k = new Date().getTime();
		System.out.println("class was created at " + k);
	}
	
	//block of code that will be executed before each new instance is created
	{
		j = new Date().getTime();
		System.out.println("I've created a new instance at " + j);
	}
	
	public Accessible(){
		System.out.println("Creating new instance of " + this.getClass().getSimpleName());
	}

	/**
	 * package-private
	 */
	void methodD(){
		System.out.println("methodD");
	}
	
	@Override
	public void methodA() {
		System.out.println("methodA");
	}

	@Override
	public void methodB() {
		System.out.println("methodB");
	}

	@Override
	public boolean methodC() {
		System.out.println("methodC");
		InnerClass inner = new InnerClass();
		System.out.println("j is " + j);
		System.out.println("inner i = " + inner.i);
		inner.innerClassMethod();
		return true;
	}
	
	public static void someStaticMethod(){
		System.out.println("some static method");
	}
	
	class InnerClass{
		private int i = 17;
		public void innerClassMethod(){
			methodD();
		}
	}

}
