package com.tj.loop;

// 구구단을 만들어 보자
public class Q3 {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + i*j + "\t");
			}
			System.out.println();
		}
	}
}
