package com.coforge.day5;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		st.push(10);
		st.push(20);
		st.push(30);
		System.out.println(st);
		
		st.pop();
		System.out.println(st);
		
		System.out.println(st.peek());
		System.out.println(st);
	}

}
