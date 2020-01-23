package com.tj.ex2_rect;

public class Rect {
	private int width;
	private int height;
	
	public int area() {
		return width * height;
	}
	
	public Rect() {}
	
	public Rect(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	public Rect(int wh) {
		this.width =wh;
		this.height = wh;
	}
	
	public void setWidth(int w) {width = w;};
	public int getWidht() {return width;}
	public void setHeight(int s) {height = s;}
	public int getHeight() {return height;}
		
}
