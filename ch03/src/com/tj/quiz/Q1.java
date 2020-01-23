package com.tj.quiz;

import java.util.Scanner;

// 사용자로부터 정수를 입력받아 3의 배수인지 아닌지 출력
public class Q1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("값을 입력하세요 : ");
		int i = scan.nextInt();
		
		System.out.println(i%3 == 0 ? i+"은(는) 3의 배수입니다." : i+"은(는) 3의 배수가 아닙니다.");
		scan.close();
	}

}
