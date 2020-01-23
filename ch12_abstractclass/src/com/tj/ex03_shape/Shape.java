package com.tj.ex03_shape;

public abstract class Shape {
	public abstract double computeArea();
	public void draw() {
		System.out.println("도형을 그려요");
	}
}
