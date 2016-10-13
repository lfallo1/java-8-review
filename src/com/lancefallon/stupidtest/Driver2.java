package com.lancefallon.stupidtest;

public class Driver2 {
	
	private static int count;
	
	static{
		System.out.println("In block 1");
		count = 10;
	}
	
	private int[] data;
	
	{
		System.out.println("In block 2");
		data = new int[count];
		for(int i = 0; i < count; i++){
			data[i] = i;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Count = " + count);
		System.out.println("Before 1st call to new");
		
		Driver2 test1 = new Driver2();
		System.out.println(test1.toString());
		System.out.println("Before second call to new");
		System.out.println(test1.toString());
		Driver2 test2 = new Driver2();
	}

}
