package com.lancefallon.exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DriverScanner {

	static String name;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		if(getNameInput(s)){
			boolean stop = false;
			while (!stop) {
				showMenu();
				try {
					int choice = Integer.parseInt(s.next());
					stop = handleChoice(choice);
				} catch (InputMismatchException | NumberFormatException e) {
					System.out.println("Please enter valid number");
					s.nextLine();
				}
			}
			s.close();
		}
	}

	private static boolean getNameInput(Scanner s) {
		System.out.println("Please enter your name:");
		try{
			name = s.next();
			while (name == null) {
				System.out.println("Please enter your name:");
				name = s.next();
			}
			System.out.println("Hello " + name + "!");
			return true;
		} catch(NoSuchElementException e){
			System.out.println(e.toString());
			s.close();
			return false;
		}
	}

	private static boolean handleChoice(int choice) {
		switch (choice) {
		case 1:
			System.out.println("This is where something would start");
			break;
		case 2:
			System.out.println("This is where i'd show you some options");
			break;
		case 3:
			System.out.println("See ya!");
			return true;
		default:
			System.out.println("Didn't quite get that....");
			break;
		}
		return false;
	}

	public static void showMenu() {
		System.out.println("Please select:");
		System.out.println("1- Start");
		System.out.println("2- Options");
		System.out.println("3- Quit");
	}

}
