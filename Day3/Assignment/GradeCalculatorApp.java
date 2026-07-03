package com.coforge.day3;

import java.util.Scanner;

public class GradeCalculatorApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Percentage in the Exam");
		
		int a = sc.nextInt();
		
		if (a >= 90 && a <= 100) {
			System.out.println("A Grade");
		}
		else if (a >= 80 && a <= 89) {
			System.out.println("B Grade");
		}
		else if (a >= 70 && a <= 79) {
			System.out.println("C Grade");
		}
		else if (a >= 60 && a <= 69) {
			System.out.println("D Grade");
		}
		else {
			System.out.println("F Grade");
		}
		
		sc.close();

	}

}
