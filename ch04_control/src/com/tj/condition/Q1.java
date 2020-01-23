package com.tj.condition;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = scan.nextInt();

		if (num > 0) {
			System.out.println("입력한 수의 절대값은 " + num + "입니다.");
		} else {
			System.out.println("입력한 수의 절대값은 " + (num * -1) + "입니다.");
		}
		scan.close();
	}
}
