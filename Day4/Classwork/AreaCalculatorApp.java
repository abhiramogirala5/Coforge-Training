package com.coforge.day4;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Rectangle rectangle = new Rectangle();
		Sqaure square = new Sqaure();
		Triangle triangle = new Triangle();
		
		rectangle.area();
		square.area();
		triangle.area();
		*/
		
		Figure fig;
		fig = new Rectangle();
		fig.area();
		fig = new Sqaure();
		fig.area();
		fig = new Triangle();
		fig.area();
		
		Rectangle r = (Rectangle) new Figure(10);
	}

}
