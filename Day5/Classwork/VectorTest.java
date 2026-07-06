package com.coforge.day5;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Integer> list = new ArrayList<>();
		
		Vector<Integer> list = new Vector<>();//correct approach for creating obj for linkedlist.
		
		list.add(new Integer(10)); 
		list.add(20); //Auto Boxing
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(20);
		System.out.println(list);
		
		System.out.println(list.get(3));
		
		list.remove(2);
		
		System.out.println(list);
		
		list.set(0, 100);
		
		System.out.println(list);
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		for(Integer i : list) {
			System.out.println(i);
		}
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Enumeration<Integer> e = list.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
	}

}
