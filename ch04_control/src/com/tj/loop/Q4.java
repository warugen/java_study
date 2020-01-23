package com.tj.loop;

// 구구단을 만들어 보자
public class Q4 {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + " * " + i + " = " + i*j + "\t");
			}
			System.out.println();
		}
	}
}
