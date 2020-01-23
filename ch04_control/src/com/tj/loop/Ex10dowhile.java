package com.tj.loop;

import java.util.Scanner;

// 짝수를 입력할때까지 사용자로부터 입력받기
public class Ex10dowhile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = scan.nextInt();
		} while (num%2 != 0);
		
		System.out.println("짝수를 잘 입력하셨네요.");
		
		scan.close();
	}
}
