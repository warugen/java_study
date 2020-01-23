package com.tj.loop;

// 주사위를 던져서 두수의 합이 6인경우
public class Homework2 {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					System.out.println("첫번째 주사위 : " + i + "\t두번째 주사위 : " + j);
				}
			}
		}
	}
}
