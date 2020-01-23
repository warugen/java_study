package com.tj.loop;

// 1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자
public class Q2 {
	public static void main(String[] args) {
		int odd = 0, even = 0;
		
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {	// 짝수구하기
				even = even + i;
			} else {	// 홀수 구하기
				odd = odd + i;
			}
		}
		
		System.out.println("1~10까지 홀수의 합 = " + odd);
		System.out.println("1~10까지 짝수의 합 = " + even);
	}
}
