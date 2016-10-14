package com.lancefallon.exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.IncompleteAnnotationException;

public class NestedExceptionsDriver {

	public static void main(String[] args) {

		try{
			
			System.out.println("starting app");
			FileWriter writer = null;
			try{
				//checked exception
				writer = new FileWriter(new File("/notfound"));
				writer.write("Hello");
			} catch(IOException e){
				e.printStackTrace();
			} finally{
				System.out.println("finally1");
				
				//unchecked null pointer inside finally
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try{
				System.out.println("continuing");
				
				try{
					//will cause runtime / unchecked exception
					int[] a = new int[10];
					a[35] = 500;
				} catch(IncompleteAnnotationException e){
					e.printStackTrace();
				} finally{
					System.out.println("finally2");
				}
				
			} catch(ArrayIndexOutOfBoundsException e){
				throw e;
			} finally{
				System.out.println("finally3");
			}
			
			System.out.println("running");
			
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("MAIN EXCEPTION");
		} finally{
			System.out.println("finally4");
		}
		
	}

}
