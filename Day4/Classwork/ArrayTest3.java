package com.coforge.day4;

import java.util.Scanner;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//int[] arr = {10 , 20 , 30 , 40 , 50};
		//int[] arr = new int[5];
		int arr[] = new int[] {10 , 20 , 30 , 40 , 50};
		
		System.out.println("Enter 5 Elements");
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println("Arr[" + i + "] : " + arr[i]);
			sum = sum + arr[i];
		}
		
		System.out.println("Sum of Array : "+sum);
		
		sc.close();
	}

}
