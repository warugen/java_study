package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int i = sc.nextInt();
		System.out.println("입력한 정수는 "+i);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("이름은 "+name);
		
		sc.nextLine();	// 버퍼에 남아있는 \n을 지우는 목적
		System.out.print("주소를 입력하세요 : ");
		String addr = sc.nextLine();
		System.out.println("입력한 주소는 : "+addr);

		System.out.println("=====끝=====");
		sc.close();
	}
}
