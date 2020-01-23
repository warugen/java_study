package com.tj.quiz;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int i = scan1.nextInt();
		
		System.out.println(i + "세는 " + ((i >= 65)? "경로우대" : "일반"));
		scan1.close();
	}

}
