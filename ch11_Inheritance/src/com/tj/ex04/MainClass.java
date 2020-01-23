package com.tj.ex04;

public class MainClass {
	public static void main(String[] args) {
		A a = new A();
//		A s = new S();	// 반대는 안된다.
		S b = new B();
		S c = new C();
		
		S[] objArr = {a, b, c};
		
		for(S tmp : objArr) {
			System.out.println(tmp.s);
		}
	}
}
