package com.tj.ex06_override;

public class ChildClass extends ParentClass {	//method1(), method2() 자동상속
	public ChildClass() {	//overloading 함수중복정의
		System.out.println("매개변수없는 ChildClass 생성자");

	}
	
	public ChildClass(int i) {
		System.out.println("매개변수있는 ChildClass 생성자");
	}
	@Override
	public void method1() {	// 오버라이드 함수의 재정의
		System.out.println("ChildClass의 method1()");
	}
	
	public void method3() {
		System.out.println("ChildClass의 method3()");
	}

	@Override
	public boolean equals(Object obj) {
		
		return true;
	}
	
}
