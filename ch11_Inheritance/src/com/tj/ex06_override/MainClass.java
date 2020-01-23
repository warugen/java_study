package com.tj.ex06_override;

public class MainClass {
	public static void main(String[] args) {
		ParentClass parentObj = new ParentClass(2);
		parentObj.method1();
		parentObj.method2();
		System.out.println("★★★★★★★★★★★★★★★★");
		ChildClass cc = new ChildClass(2);
		cc.method1();
		cc.method2();
		cc.method3();
		
		if(cc.equals(parentObj)) {
			System.out.println("둘이 같다");
		}
	}
}
