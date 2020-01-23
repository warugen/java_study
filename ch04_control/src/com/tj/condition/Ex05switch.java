package com.tj.condition;

import java.util.Scanner;

public class Ex05switch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("입력할 수 : ");
		int num = scan.nextInt();

		switch (num % 2) {
		case 0:
			System.out.println("짝수를 입력했군요.");
			break;
		default:
			System.out.println("홀수를 입력했군요.");
			break;
		}
		scan.close();
	}
}
