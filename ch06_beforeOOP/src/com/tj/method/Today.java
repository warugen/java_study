package com.tj.method;

import java.util.Scanner;

// 구구단 입력받아 출력하기
public class Today {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
			System.out.print("출력할 단수를 입력하세요 : ");
			num = sc.nextInt();
			if (num <2 || num > 9) {
				System.out.println("2~9단 사이의 숫자를 입력하세요.");
			} else {
				guguPrint(num);
				break;
			}
		} while (num <2 || num > 9);
		
		sc.close();
	}
	
	private static void guguPrint(int value) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(value + " * " + i + " = " + value*i);
		}
	}
}
