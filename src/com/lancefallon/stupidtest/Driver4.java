package com.lancefallon.stupidtest;

interface MyInterface{
	Integer i = new Integer(50);
}

public class Driver4 implements MyInterface{
	
	public Driver4(Integer value){
		System.out.println(i);
	}
	
	public static void main(String[] args){
		String s1 = "a";
		String s2 = new String("a");
		
		System.out.println(s1==s2); // false
		System.out.println(s1.matches(s2)); //true
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.hashCode()==s2.hashCode());//true
	}
}