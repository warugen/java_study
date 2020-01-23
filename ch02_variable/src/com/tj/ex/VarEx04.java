package com.tj.ex;

public class VarEx04 {
	public static void main(String args[]) {
		// 변수 선언방법
		
		// 1. 자료형 변수명;
		// 변수의 선언과 값의 대입을 분리하는 방법
		int num1;
		num1 = 10;
		
		// 2. 자료형 변수명 = 값;
		// 변수 선언과 동시에 값을 대입하는 방법
		int num2 = 20;
		
		// 3. 자료형 변수명1, 변수명2;
		// 동일한 ㅏ료형 타입의 변수를 다수개 선언하는 방법
		int num3, num4;
		
		
		// 4. 자료형 변수명1 = 값1, 변수명2 = 값2;
		// 동일한 자료형 타입의 변수를 다수개 선언하면서 값을 대입하는 방법
		int num5 = 50, num6 = 60;
		int num7, num8 = 80, num9;
		num3 = 30; num4 = 40; num7 = 70; num9 = 90;
		System.out.println("num1="+num1+"\t num2=" + num2);
		System.out.println("num3="+num3+"\t num4=" + num4);
		System.out.println("num5="+num5+"\t num6=" + num6);
		System.out.printf("num7=%d\t num8=%d\t num9=%d\n", num7, num8, num9);
	}

}
