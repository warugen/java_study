package com.tj.ex4_object;

// clone하려면 인터페이스 Cloneable을 반드시 추가해야한다. 
// 그다음에 clone을 오버라이드해야한다.
public class Rectangle implements Cloneable {	// 빨강색 가로5 세로6 네모
	private int width;
	private int height;
	private String color;
	
	public Rectangle() {}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	@Override
	public String toString() {
		// 가로: 세로 : 색상 : 
		return "가로 : " + width + ", 세로 : " + height + ", 색상 : " + color + "인 네모";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Rectangle) {
			boolean widthOk = this.width == ((Rectangle)obj).width;
			boolean heightOk = this.height == ((Rectangle)obj).height;
			boolean colOk = this.color.equals(((Rectangle)obj).color);
			
			return ( widthOk && heightOk && colOk) ;
			
		} else {
			return false;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
