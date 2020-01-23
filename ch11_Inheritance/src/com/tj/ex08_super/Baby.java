package com.tj.ex08_super;

public class Baby extends Person {

	public Baby() {
		System.out.println("매개변수없는 Baby");
	}
	
	public Baby(String name, String character) {
//		setName(name);
//		setCharacter(character);
//		System.out.println("매개변수 2개짜리 Baby");
		// super() : 내 클래스의 슈퍼단의 생성자 함수 호출
		super(name, character);
	}
	
	@Override
	public void intro() {
		// super. : 내 클래스의 슈퍼단의
		System.out.println("응애응애 난 아기야");
		super.intro();
	}
}
