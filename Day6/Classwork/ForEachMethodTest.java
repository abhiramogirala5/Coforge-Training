package com.coforge.day6;

import java.util.Arrays;
import java.util.List;

public class ForEachMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(10, 20, 30, 40, 55, 65);
		
		list.forEach(n -> System.out.println(n));
		
		System.out.println("--------------------");
		
		list.forEach(n -> {
			if(n %2 ==0)
				System.out.println(n);
		});
		
		System.out.println("--------------------");
		
		list.forEach(System.out::println);

	}

}
