package com.coforge.day5;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer , String> map = new TreeMap<>(Collections.reverseOrder());
		map.put(10, "Java");
		map.put(20, "Python");
		map.put(30, "C++");
		map.put(40, "JavaScript");
		System.out.println(map);
		
		map.put(10, "React"); //Duplicates in Map Updates
		System.out.println(map); 
		
		map.remove(30);
		System.out.println(map);
		
		System.out.println(map.get(10));
		
		Set<Integer> keys = map.keySet();
		for(Integer key : keys)
			System.out.println(key + " => " + map.get(key));
		
		Set<Map.Entry<Integer, String>> entries = map.entrySet();

		for (Map.Entry<Integer, String> entry : entries) {
		    System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

}
