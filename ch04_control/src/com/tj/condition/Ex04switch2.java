package com.tj.condition;

import java.util.Scanner;

public class Ex04switch2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("점수를 입력하세요 : ");

		int num = scan.nextInt();
		int tmp = (num == 100) ? num-1 : num;

		switch (tmp / 10) {
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("F학점");
			break;
		default:
			System.out.println("유효하지않은 점수");
			break;
		}

		scan.close();
	}
}
