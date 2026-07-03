package com.coforge.day3;

import java.util.Scanner;

public class SumOfNaturalNumbersApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		
		int n = sc.nextInt();
		
		int sum = (n * (n+1))/2;
		
		System.out.println("Summ : " +sum);
		
		sc.close();

	}

}
