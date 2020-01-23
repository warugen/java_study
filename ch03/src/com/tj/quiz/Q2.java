package com.tj.quiz;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("값을 입력하세요 : ");
		int i = scan.nextInt();
		
		System.out.println(i%2 == 0 ? i+"은(는) 짝수입니다." : i+"은(는) 홀수입니다.");
		scan.close();
	}

}
