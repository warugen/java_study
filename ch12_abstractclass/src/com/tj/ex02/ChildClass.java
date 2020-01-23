package com.tj.ex02;

public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의 method1()-추상메소드라서 반드시 오버라이드 함");
	}
	
	@Override
	public void method2() {
		System.out.println("ChildClass의 method1()-그냥 오버라이드 해봄");
	}

}
