package com.coforge.day6;

interface MyInterface {
	public default void myMethod1() {
		System.out.println("Default Method");
	}
	
	public void myMethod2();
	
	public static void myMethod3() {
		System.out.println("Static Method");
	}
}

public class Java8InterfaceTest implements MyInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myMethod2() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void myMethod1() {
		System.out.println("Default Method");
	}
	
	//@Override
	//public void myMethod3() {
	//	System.out.println("Static Method");
	//}

}
