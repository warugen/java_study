package com.tj.quiz;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("주민번호 7번째 숫자를 입력하세요 : ");
		int i = scan1.nextInt();
		
		String str = (i == 1 || i == 3)? "남자" : (i == 2 || i ==4)? "여자" : "누구냐 넌";
		System.out.println(str);
		
		scan1.close();
	}
}
