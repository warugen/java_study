package com.tj.ex6_boxorrect;

public class BoxOrRectMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 6, 10);
		BoxOrRect rect = new BoxOrRect(10, 5);
		
		box.calVolume();
		rect.calVolume();
		System.out.println("가로 : "+box.getWidth()+"\t세로 : "+box.getHeight()+"\t높이 : "+box.getDepth()+"\t부피 : "+box.getVolume());
		System.out.println("가로 : "+rect.getWidth()+"\t세로 : "+rect.getHeight()+"\t넓이 : "+rect.getVolume());
	}
}
