package com.coforge.day3;

import java.util.Scanner;

public class EvenOddApp {

	public static void main(String[] args) {
		System.out.println("Enter a Number");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if (n % 2 == 0) {
			System.out.println("Even Number");
		}
		else {
			System.out.println("Odd Number");
		}
		
		sc.close();
	}

}
