package com.tj.loop;

import java.util.Scanner;

// 사용자로부터 원하는 단수의 구구단을 만들어 보자
public class Q5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 단수의 구구단을 입력하세요 : ");
		
		int num = scan.nextInt();
		
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(num + " * " + i + " = " + num*i);
		}
		
		scan.close();
	}
}
