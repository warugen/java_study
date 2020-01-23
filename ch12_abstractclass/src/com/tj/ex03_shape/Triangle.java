package com.tj.ex03_shape;

public class Triangle extends Shape {

	private int w;
	private int h;
		
	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}


	@Override
	public double computeArea() {
		
		return w * h * 0.5;
	}
	
	@Override
	public void draw() {
		System.out.print("삼각형 ");
		super.draw();
	}

}
