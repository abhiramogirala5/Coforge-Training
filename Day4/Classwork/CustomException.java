package com.coforge.day4;

import java.util.Scanner;

public class CustomException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Age");
		int age = sc.nextInt();

		if (age >= 18) {
			System.out.println("Eligible to Vote");
		} else {
			try {
				throw new InvalidAgeException();
			} catch (InvalidAgeException e) {
				System.out.println(e.toString());
			}

		}
		
		sc.close();

	}

}
