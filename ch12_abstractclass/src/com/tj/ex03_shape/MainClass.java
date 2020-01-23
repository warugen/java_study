package com.tj.ex03_shape;

public class MainClass {
	public static void main(String[] args) {
		Shape[] shape = { new Circle(5), new Triangle(10, 5), new Rectangle(5, 3)};
		
		for(Shape s : shape) {
			System.out.println("도형 넓이 : " + s.computeArea());
			s.draw();
		}
	}
}
