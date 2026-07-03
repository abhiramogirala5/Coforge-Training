package com.coforge.day3;

import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		String conformation = "";
		
		do {
		System.out.println("Enter Two Numbers");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println("1.Add 2.Sub 3.Mul 4.Div 5.Quit");
		System.out.println("Enter your Choice");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			res = a + b;
			System.out.println("Addition : "+res);
			break;
		case 2:
			res = a - b;
			System.out.println("Substraction : "+res);
			break;
		case 3:
			res = a * b;
			System.out.println("Multiplication : "+res);
			break;
		case 4:
			res = a + b;
			System.out.println("Division : "+res);
			break;
		case 5:
			System.out.println("Byee!");
			System.exit(0);
		}
	    System.out.println("Do you want to continue [Yes | No]");
	    conformation = sc.next();
	 }while(conformation.equalsIgnoreCase("Yes"));
		
		sc.close();
		

	}

}