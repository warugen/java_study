package com.tj.ex;

// 일반for문 , 확장for문
public class Ex07 {
	public static void main(String[] args) {
		String[] names = {"홍길동","김길동","김제동"};
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		// 확장for문
		for(String n : names) {
			System.out.println(n);
		}
		
	}
}
