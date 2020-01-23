package com.tj.ex1_trycatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i =0;
		int j =0;
		do {
			try {
				System.out.print("첫번째 정수 i입력 : ");
				i = sc.nextInt();
				break;
			} catch (Exception e) {
//				e.printStackTrace();
				sc.nextLine();	// 버퍼를 지운다.
				System.out.println("숫자만 입력해주세요");
			}
		} while (true);
		
		
		System.out.println("i= "+i);
		
		System.out.print("두번째 정수 j입력 : ");
		try {
			j = sc.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("j= "+j);
		
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j));
		} catch (Exception e) {
			e.printStackTrace();	// e.getMessage()보다 자세히나오지만 자주 사용하지는 않는다.
			System.out.println(e.getMessage());
			System.out.println("0으로 나눌수 없습니다.");
		}
		
		
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		sc.close();
		
	}
}
