package com.tj.ex01_parentchild;

public class MainClass {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
//		ParentClass child = new ChildClass();
		child.getMamName();
		child.getPapaName();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}
}
