package com.tj.op;
// 비트연산자
public class Ex07 {
	public static void main(String[] args) {
		int i1 = 10; // 0 0 0 0 1 0 1 0
		int i2 = 5;  // 0 0 0 0 0 1 0 1
		int result = i1 & i2;  // 0 0 0 0 0 0 0 0
		System.out.println(result);

		result = i1 | i2;  // 0 0 0 0 1 1 1 1 -> 15
		System.out.println(result);
		
		result =  i1 << 1;  // 0 0 0 1 0 1 0 0
		System.out.println(result);
	}

}
