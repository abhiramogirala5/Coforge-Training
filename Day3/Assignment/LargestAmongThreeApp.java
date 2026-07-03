package com.coforge.day3;

import java.util.Scanner;

public class LargestAmongThreeApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Three Numbers");
		
		int a = sc.nextInt(); 
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if (a >= b && a >= c) {
			System.out.println("a is Greater Number");
		}
		if (b >= a && b >= c) {
			System.out.println("b is Greater Number");
		}
		if (c >= a && c >= b) {
			System.out.println("c is Greater Number");
		}
		
		sc.close();

	}

}
