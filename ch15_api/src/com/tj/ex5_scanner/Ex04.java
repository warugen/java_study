package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("이름? ");
		String name = scMain.next();
		action(scMain);
		
		System.out.print("나이를 입력하세요 : ");
		int age =scMain.nextInt();
		System.out.println("입력한 나이는 "+age);
		System.out.println("------끝------");
		scMain.close();
	}

	private static void action(Scanner scAction) {
		// 별명을 받아 출력하는 일
//		Scanner scAction = new Scanner(System.in);
		System.out.print("별명을 입력하세요 : ");
		String nick = scAction.next();
		System.out.println("별명은 " + nick);
//		scAction.close();
	}
}
