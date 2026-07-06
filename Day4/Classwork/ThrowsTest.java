package com.coforge.day4;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsTest {

    public static class MyClass { 
        
        public static void myMethod() throws FileNotFoundException {
            FileReader fr = new FileReader("Demo.txt");
        }
    }

    public static void main(String[] args) {
    	
    	//int a = 0;
		
    	//FileReader fr = new FileReader("Demo.txt");
    	
        try {
            MyClass.myMethod();
        } catch (FileNotFoundException e) { // Better practice to catch the specific exception
            System.err.println("The specified file was not found.");
            e.printStackTrace();
        }
    }
}
