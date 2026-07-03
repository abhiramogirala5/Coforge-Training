package com.coforge.day3;

import java.util.Scanner;

public class PrimeCheckApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer to check: ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else if (num == 2) {
                isPrime = true;
            } else if (num % 2 == 0) {
                isPrime = false;
            } else {
                for (int i = 3; i <= Math.sqrt(num); i += 2) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
        
        scanner.close();

	}

}
