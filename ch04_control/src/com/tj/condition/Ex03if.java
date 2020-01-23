package com.tj.condition;

import java.util.Scanner;

public class Ex03if {
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.print("첫번째 수 입력하시오 : ");
		int num1 = scan1.nextInt();
		
		System.out.print("두번째 수 입력하시오 : ");
		int num2 = scan2.nextInt();
		
		if (num1 > num2) {
			System.out.println("첫번째 입력값 " + num1 + "이 더 크다");
		} else if (num1 < num2){
			System.out.println("두번째 입력값 " + num2 + "이 더 크다");
		} else {
			System.out.println("같은 수를 두번 입력했네");
		}
		
		scan1.close();
		scan2.close();
	}
}
