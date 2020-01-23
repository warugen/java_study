package com.tj.loop;

// 1~10까지 곱을 구하기
public class Q1 {
	public static void main(String[] args) {
		int tot = 1;

		for (int i = 1; i <= 10; i++) {
			tot = tot * i;
		}

		System.out.println("1부터 10까지의 곱은 = "+tot);
	}
}
