package com.tj.ex1_square;

public class SquareMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		s1.setSide(5);
		
		Square s2 = new Square(7);
		
		System.out.println(s1.getSide()+"길이의 Square 넓이 = " + s1.area());
		System.out.println(s2.getSide()+"길이의 Square 넓이 = " + s2.area());
	}
}
