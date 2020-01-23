package com.tj.ex3_accestest1;

public class AccessTest {
	private int privateMember = 10;			
	int defaultMember = 20;					// 같은 패키지안에서 호출가능
	protected int protectedMember = 30;		// 같은 패키지거나 상속받으면 호출가능
	public int publicMember = 40;			// 접근제한 없음
	
	private void privateMethod() {
		System.out.println("private Method");
	}
	
	void defaultMethod() {
		System.out.println("default Method");
	}
	
	protected void protectedMethod() {
		System.out.println("protected Method");
	}
	
	public void publicMethod() {
		System.out.println("public Method");
	}
}
