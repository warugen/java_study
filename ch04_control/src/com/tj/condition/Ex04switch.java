package com.tj.condition;

import java.util.Scanner;

public class Ex04switch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요 : ");
		
		int num = scan.nextInt();
		
		if (90 <= num && num<=100) {
			System.out.println("A학점");
		} else if (80 <=num && num <90) {
			System.out.println("B학점");
		} else if (70 <=num && num <80) {
			System.out.println("C학점");
		} else if (60 <=num && num <70) {
			System.out.println("D학점");
		} else if (0 <=num && num <60) {
			System.out.println("F학점");
		} else {
			System.out.println("유효하지않은 점수입니다.");
		}
		
		scan.close();
	}
}
