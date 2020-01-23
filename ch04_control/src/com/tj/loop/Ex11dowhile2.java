package com.tj.loop;
// 1부터 45까지 임의의 숫자 맞추기

import java.util.Scanner;

public class Ex11dowhile2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lotto = 0; // 임의의 수
		int num; // 사용자가 선택한 수
		int min = 1, max = 45;

		lotto = (int) (Math.random() * 45) + 1;
		System.out.println(lotto);

		do {
			System.out.printf("%d부터 %d사이의 수를 입력하세요 : ", min , max);
			num = scan.nextInt();

			if (num<min || num>max) {
				System.out.println("입력범위를 지켜주세요.");
			} else if (num < lotto) {
				min = num + 1;
				System.out.printf("입력한 값 %d보다 큰수를 입력해주세여\n", num);
				
			} else if (num > lotto) {
				max = num - 1;
				System.out.printf("입력한 값 %d보다 작은수를 입력해주세여\n", num);
			}

		} while (num != lotto);

		System.out.println("정답입니다.");

		scan.close();
	}
}
