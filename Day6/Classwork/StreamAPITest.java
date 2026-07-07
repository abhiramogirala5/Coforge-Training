package com.coforge.day6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StreamAPITest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 12, 13, 14, 15);

		long count = list.stream().filter(n -> n % 2 == 0).count();

		System.out.println(count);
		
		System.out.println("--------------------");

		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
		
		System.out.println("--------------------");
		
		list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).forEach(System.out::println);
		
		System.out.println("--------------------");
		
		List<String> names = Arrays.asList("Abhi" , "Ram" , "Ramesh" , "Suresh");
		
		names.stream().filter(n -> n.contains("a")).map(n -> n.length()).forEach(System.out::println);
		
		System.out.println("--------------------");
		
		Date date = new Date();
		System.out.println(date);
		
		System.out.println("--------------------");
		
		LocalDate dat = LocalDate.now();
		System.out.println(dat);
		
		System.out.println("--------------------");
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		System.out.println("--------------------");
		
		
		
		

	}
}
