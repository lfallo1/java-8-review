package com.lancefallon.exceptions;

public class DriverFinally {

	public static void main(String[] args) {
		try{
			System.out.println(divide(10,2));
			System.out.println(divide(10, 0));
			System.out.println(divide(10,5));	
		} catch(ArithmeticException e){
			System.out.println(e.toString());
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.toString());
		}
	}
	
	public static int divide(int a, int b){
		
		try{
			return a / b;
		} catch(ArithmeticException e){
			throw e;
		} finally{
			//if we return here, this method would always return 1 (even if no error thrown)
//			return 1;
			
			//Errors in a finally: it is this error that will be thrown, not the one in try/catch
			//in this instance, that means an IndexOutOfBoundsException would be thrown instead of a potential DivideByZero.
			//An error here also prevents the code in try/catch from behaving normally (i.e., even it calculated fine, this method will throw an error)
//			int[] c = new int[10];
//			c[35] = 500;
		}
	}

}
