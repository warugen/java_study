package com.tj.condition;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("국어 점수를 입력하세요 : ");
		int kor = scan.nextInt();

		System.out.print("영어 점수를 입력하세요 : ");
		int eng = scan.nextInt();

		System.out.print("수학 점수를 입력하세요 : ");
		int math = scan.nextInt();

		int total = kor + eng + math;

		double avg = total / 3.0;

		System.out.printf("평균 점수 : %.2f\n", avg);

		if (kor > avg) {
			System.out.println("국어 점수가 평균 이상입니다.");
		} else {
			System.out.println("국어 점수가 평균 이하입니다.");
		}

		if (eng > avg) {
			System.out.println("영어 점수가 평균 이상입니다.");
		} else {
			System.out.println("영어 점수가 평균 이하입니다.");
		}

		if (math > avg) {
			System.out.println("수학 점수가 평균 이상입니다.");
		} else {
			System.out.println("수학 점수가 평균 이하입니다.");
		}

		scan.close();

	}
}
