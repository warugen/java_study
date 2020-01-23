package com.tj.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주소를 입력하세요 : ");
		String addr = sc.nextLine();
		System.out.println("입력한 주소는 : "+addr);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("입력한 이름은 "+name+"입니다.");
		
		System.out.print("정수를 입력하세요 : ");
		int i = sc.nextInt();
		System.out.println("입력한 정수는 "+i+"입니다.");
		
		System.out.println("------끝------");
		sc.close();
	}
}
