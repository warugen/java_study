package com.tj.ex02;

import com.tj.ex02_protected.Child;

public class MainClass {
	public static void main(String[] args) {
		Child child = new Child();
		child.setIJ(10, 20);
//		System.out.println("I는 "+child.getI());		// protected로 되어있어서 못가져옴
//		System.out.println("J는 "+child.getJ());		// protected로 되어있어서 못가져옴
		child.sum();
	}
}
