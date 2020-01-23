package com.tj.ex03_shape;

public class Rectangle extends Shape {
	private int w;
	private int h;
	
	
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}


	@Override
	public double computeArea() {
		return w * h;
	}
	
	@Override
	public void draw() {
		System.out.print("사각형 ");
		super.draw();
	}

}
