package com.coforge.day3;

import java.util.Scanner;

public class ReverseNumberApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		
		int n = sc.nextInt();
		int reversed = 0;
		
		while (n != 0) {
            int digit = n % 10;          
            reversed = reversed * 10 + digit; 
            n /= 10;                     
        }
		

		System.out.println("Reversed Number: " + reversed);
		
		sc.close();
	}

}
