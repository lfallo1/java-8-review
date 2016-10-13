package com.lancefallon.section8.modifiers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Driver {

	public static void main(String[] args){
		IAccessible acc = new Accessible();
		acc.methodA();
		acc.methodB();
		acc.methodC();
		
		Accessible acc2 = new Accessible();
		acc2.methodD();
		acc2.methodC();
		System.out.println(IAccessible.ACC_COUNTER);
		Accessible.InnerClass inner = acc2.new InnerClass();
		inner.innerClassMethod();
		
		//create new instance of class with private constructor (just because...)
		Constructor<?>[] cs = Math.class.getDeclaredConstructors();
		for (Constructor<?> c : cs) {
			try {
				c.setAccessible(true);
				Math m = (Math)c.newInstance();
				System.out.println(m.abs(-30.0));
				break;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
